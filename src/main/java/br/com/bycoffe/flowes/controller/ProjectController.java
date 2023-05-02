package br.com.bycoffe.flowes.controller;

import java.time.LocalDateTime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.project.dto.DetailsDataProject;
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    
    Logger log = LoggerFactory.getLogger(ProjectController.class);
    
    @Autowired
    ProjectRepository repository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    PagedResourcesAssembler<ListingDataProject> assembler;


    private Project getProject(Long id) {
        return repository.findById(id).orElseThrow(() -> { 
            return new RestNotFoundException("Nenhum projeto com o [ " +
            id +
            " ] foi encontrado."
            ); 
        });
    }



    @GetMapping
    public PagedModel<EntityModel<ListingDataProject>> search(@PageableDefault(size = 10) Pageable pagination) {
        log.info("[ Search ] Buscando Projects");
        Page<ListingDataProject> projects = repository.findAllByCompleteFalse(pagination).map(ListingDataProject::new);
        PagedModel<EntityModel<ListingDataProject>> pagedModel = assembler.toModel(projects);

        return pagedModel;
    }


    @PostMapping
    public ResponseEntity<DetailsDataProject> create(
        @RequestBody @Valid RegisterDataProject projectDTO,
        BindingResult result
        ) {

        log.info("[ Create ] Cadastrando Project: " + projectDTO); 
        Project project = new Project(projectDTO);
        repository.save(project);
        project.setWorkspace(workspaceRepository.findById(projectDTO.workspace().getId()).get());
        DetailsDataProject projectCreated = new DetailsDataProject(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectCreated);
    }


    @GetMapping("{id}")
    public ResponseEntity<DetailsDataProject> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Project: " + id);

        Project projectEncontrado = getProject(id);

        DetailsDataProject project = new DetailsDataProject(projectEncontrado);

        return ResponseEntity.ok(project);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DetailsDataProject> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Project: " + id);

        Project projectEncontrado = getProject(id);

        repository.delete(projectEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailsDataProject> update(@PathVariable Long id, @RequestBody Project project) {
        log.info("[ Update ] Atualizando Project: " + id);

        Project projetoEncontrado = getProject(id);

        project.setId(id);
        project.setUpdatedAt(LocalDateTime.now());
        project.setWorkspace(projetoEncontrado.getWorkspace());
        repository.save(project);

        DetailsDataProject projectUpdated = new DetailsDataProject(project);

        return ResponseEntity.ok(projectUpdated);
    }

}

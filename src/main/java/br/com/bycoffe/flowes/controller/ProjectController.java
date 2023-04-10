package br.com.bycoffe.flowes.controller;

import java.time.LocalDateTime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    
    Logger log = LoggerFactory.getLogger(ProjectController.class);
    
    @Autowired
    ProjectRepository repository;


    private Project getProject(Long id) {
        return repository.findById(id).orElseThrow(() -> { 
            return new RestNotFoundException("Nenhum projeto com o [ " +
            id +
            " ] foi encontrado."
            ); 
        });
    }



    @GetMapping
    public ResponseEntity<Page<ListingDataProject>> returnClient(@PageableDefault(size = 10) Pageable pagination) {
        log.info("[ Search ] Buscando Projects"); 
        Page<ListingDataProject> pages = repository.findAllByActiveTrue(pagination).map(ListingDataProject::new);
        return ResponseEntity.ok(pages);
    }


    @PostMapping
    public ResponseEntity<Project> create(
        @RequestBody @Valid Project project,
        BindingResult result
        ) {

        log.info("[ Create ] Cadastrando Project: " + project); 

        repository.save(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }


    @GetMapping("{id}")
    public ResponseEntity<Project> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Project: " + id);

        Project projectEncontrado = getProject(id);

        return ResponseEntity.ok(projectEncontrado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Project> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Project: " + id);

        Project projectEncontrado = getProject(id);

        repository.delete(projectEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project) {
        log.info("[ Update ] Atualizando Project: " + id);

        getProject(id);

        project.setId(id);
        project.setUpdatedAt(LocalDateTime.now());
        repository.save(project);
        
        return ResponseEntity.ok(project);
    }

}

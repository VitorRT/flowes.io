package br.com.bycoffe.flowes.service.project.impl;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.project.dto.DetailsDataProject;
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.project.dto.UpdateDataProject;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import br.com.bycoffe.flowes.service.project.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ProjectServiceImpl implements IProjectService {
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

    @Override
    public PagedModel<EntityModel<ListingDataProject>> search(Pageable pagination) {
        log.info("[ Search ] Buscando Projects");
        Page<ListingDataProject> projects = repository.findAllByCompleteFalse(pagination).map(ListingDataProject::new);
        PagedModel<EntityModel<ListingDataProject>> pagedModel = assembler.toModel(projects);

        return pagedModel;
    }

    @Override
    public DetailsDataProject create(RegisterDataProject request) {
        log.info("[ Create ] Cadastrando Project: " + request);
        Project project = new Project(request);
        repository.save(project);
        project.setWorkspace(workspaceRepository.findById(request.workspace().getId()).get());
        DetailsDataProject projectCreated = new DetailsDataProject(project);

        return projectCreated;
    }

    @Override
    public DetailsDataProject show(Long id) {
        log.info("[ Show ] Buscando Project: " + id);
        Project projectEncontrado = getProject(id);
        DetailsDataProject project = new DetailsDataProject(projectEncontrado);

        return project;
    }

    @Override
    public void destroy(Long id) {
        log.info("[ Destroy ] Apagando Project: " + id);
        Project projectEncontrado = getProject(id);

        repository.delete(projectEncontrado);
    }

    @Override
    public DetailsDataProject update(Long id, UpdateDataProject request) {
        log.info("[ Update ] Atualizando Project: " + id);
        getProject(id);
        Project project = new Project(request);
        project.setId(id);
        project.setUpdatedAt(LocalDateTime.now());
        repository.save(project);
        DetailsDataProject projectUpdated = new DetailsDataProject(project);

        return projectUpdated;
    }
}

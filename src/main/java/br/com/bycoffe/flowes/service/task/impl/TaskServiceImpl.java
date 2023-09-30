package br.com.bycoffe.flowes.service.task.impl;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.models.task.dto.DetailsDataTask;
import br.com.bycoffe.flowes.models.task.dto.ListingDataTask;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.task.dto.UpdateDataTask;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.TaskRepository;
import br.com.bycoffe.flowes.service.task.ITaskService;
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
public class TaskServiceImpl implements ITaskService {
    @Autowired
    TaskRepository repository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    PagedResourcesAssembler<ListingDataTask> assembler;

    private Task getTask(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhuma task com o [ " +
                    id +
                    " ] foi encontrada!"
            )
        );
    }

    private Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhum projeto com o [ " +
                    id +
                    " ] foi encontrado!"
            )
        );
    }

    @Override
    public PagedModel<EntityModel<ListingDataTask>> search(Pageable pagination) {
        log.info("[ Search ] Buscando Tasks");
        Page<ListingDataTask> tasks = repository.findAllByCompleteFalse(pagination).map(ListingDataTask::new);
        PagedModel<EntityModel<ListingDataTask>> pagedModel = assembler.toModel(tasks);

        return pagedModel;
    }

    @Override
    public DetailsDataTask create(RegisterDataTask request) {
        log.info("[ Create ] Cadastrando Task: " + request.name());
        Project project = getProject(request.project().getId());
        Task task = new Task(request);
        repository.save(task);
        task.setProject(project);
        DetailsDataTask taskCreated = new DetailsDataTask(task);
        return taskCreated;
    }

    @Override
    public DetailsDataTask show(Long id) {
        log.info("[ Show ] Buscando Task: " + id);
        Task taskEncontrado = getTask(id);
        DetailsDataTask task = new DetailsDataTask(taskEncontrado);

        return task;
    }

    @Override
    public void destroy(Long id) {
        log.info("[ Destroy ] Apagando Task: " + id);
        Task taskEncontrado = getTask(id);
        repository.delete(taskEncontrado);
    }

    @Override
    public DetailsDataTask update(Long id, UpdateDataTask request) {
        log.info("[ Update ] Atualizando Task: " + id);
        getTask(id);
        Task task = new Task(request);
        task.setId(id);
        task.setUpdatedAt(LocalDateTime.now());
        repository.save(task);
        DetailsDataTask taskUpdated = new DetailsDataTask(task);

        return taskUpdated;
    }
}

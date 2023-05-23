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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.models.task.dto.DetailsDataTask;
import br.com.bycoffe.flowes.models.task.dto.ListingDataTask;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "Task ✅")
public class TaskContoller {
    
    Logger log = LoggerFactory.getLogger(TaskContoller.class);
    
    @Autowired
    TaskRepository repository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    PagedResourcesAssembler<ListingDataTask> assembler;


    private Task getTask(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RestNotFoundException("Nenhuma task com o [ " +
            id +
            " ] foi encontrada!"
            ); 
        });
    }



    @GetMapping
    @Operation(
        summary = "Listagem de tarefas.",
        description = "Listagem geral de todas as tarefas cadastradas e ativas."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados das tarefas foram retornados.")
    }
    )
    public PagedModel<EntityModel<ListingDataTask>> search(@PageableDefault(size = 10) Pageable pagination) {
        log.info("[ Search ] Buscando Tasks");
        Page<ListingDataTask> tasks = repository.findAllByCompleteFalse(pagination).map(ListingDataTask::new);
        PagedModel<EntityModel<ListingDataTask>> pagedModel = assembler.toModel(tasks);

        return pagedModel;
    }

    @PostMapping
    @Operation(
        summary = "Cadastro de uma tarefa.",
        description = "Cadastro de uma tarefa. Para poder cadastrar é preciso informar o id do projeto."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "201", description = "A tarefa foi criada com sucesso."),   
        @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")   
    }
    )
    public ResponseEntity<DetailsDataTask> create(@RequestBody RegisterDataTask taskDTO) {
        log.info("[ Create ] Cadastrando Task: " + taskDTO.name()); 

        Task task = new Task(taskDTO);
        repository.save(task);
        task.setProject(projectRepository.findById(taskDTO.project().getId()).get());
        DetailsDataTask taskCreated = new DetailsDataTask(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhamento de tarefa.",
        description = "Detalhamento de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados da tarefa foram retornados."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataTask> show(@PathVariable Long id) {
        log.info("[ Show ] Buscando Task: " + id);
        Task taskEncontrado = getTask(id);

        DetailsDataTask task = new DetailsDataTask(taskEncontrado);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deleção de tarefa.",
        description = "Deleção de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "204", description = "A tarefa foi deletada com sucesso."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataTask> destroy(@PathVariable Long id) {
        log.info("[ Destroy ] Apagando Task: " + id);
        Task taskEncontrado = getTask(id);
        repository.delete(taskEncontrado);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Edição de tarefa.",
        description = "Edição de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados da tarefa foram retornados."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataTask> update(@PathVariable Long id, @RequestBody Task task) {
        log.info("[ Update ] Atualizando Task: " + id);
        Task taskEncontrado = getTask(id);
        task.setId(id);
        task.setUpdatedAt(LocalDateTime.now());
        task.setProject(taskEncontrado.getProject());
        repository.save(task);

        DetailsDataTask taskUpdated = new DetailsDataTask(task);
        
        return ResponseEntity.ok(taskUpdated);
    }
}

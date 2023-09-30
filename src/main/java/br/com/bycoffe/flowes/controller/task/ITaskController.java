package br.com.bycoffe.flowes.controller.task;

import br.com.bycoffe.flowes.models.task.dto.DetailsDataTask;
import br.com.bycoffe.flowes.models.task.dto.ListingDataTask;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.task.dto.UpdateDataTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITaskController {
    @Operation(
            summary = "Listagem de tarefas.",
            description = "Listagem geral de todas as tarefas cadastradas e ativas."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados das tarefas foram retornados.")
    }
    )
    ResponseEntity<PagedModel<EntityModel<ListingDataTask>>> search(@PageableDefault(size = 10) Pageable pagination);

    @Operation(
            summary = "Cadastro de uma tarefa.",
            description = "Cadastro de uma tarefa. Para poder cadastrar é preciso informar o id do projeto."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "201", description = "A tarefa foi criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")
    }
    )
    ResponseEntity<DetailsDataTask> create(@RequestBody @Valid RegisterDataTask request);

    @Operation(
            summary = "Detalhamento de tarefa.",
            description = "Detalhamento de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados da tarefa foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")
    }
    )
    ResponseEntity<DetailsDataTask> show(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Deleção de tarefa.",
            description = "Deleção de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "204", description = "A tarefa foi deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")
    }
    )
    ResponseEntity<DetailsDataTask> destroy(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Edição de tarefa.",
            description = "Edição de uma tarefa cadastrada e ativa. É preciso informar o id da tarefa no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados da tarefa foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe uma tarefa com esse ID.")
    }
    )
    ResponseEntity<DetailsDataTask> update(@PathVariable(value = "id") Long id, @RequestBody @Valid UpdateDataTask request);
}

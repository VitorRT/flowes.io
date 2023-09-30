package br.com.bycoffe.flowes.controller.workspace;

import br.com.bycoffe.flowes.models.workspace.dto.DetailsDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IWorkspaceController {
    @Operation(
            summary = "Listagem de workspaces.",
            description = "Listagem geral de todas as workspaces cadastradas e ativas."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados das workspaces foram retornados.")
    }
    )
    ResponseEntity<PagedModel<EntityModel<ListingDataWorkspace>>> search(@ParameterObject @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pagination);

    @Operation(
            summary = "Cadastro de uma workspace.",
            description = "Cadastro de uma workspace. Para poder cadastrar é preciso informar o id do cliente."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "201", description = "A worskpace foi criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")
    }
    )
    ResponseEntity<DetailsDataWorkspace> create(@RequestBody @Valid RegisterDataWorkspace request, BindingResult result);

    @Operation(
            summary = "Detalhamento de workspace.",
            description = "Detalhamento de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados da workspace foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")
    }
    )
    ResponseEntity<DetailsDataWorkspace> show(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Deleção de workspace.",
            description = "Deleção de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "204", description = "A workspace foi deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")
    }
    )
    ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Edição de workspace.",
            description = "Edição de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados da workspace foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")
    }
    )
    ResponseEntity<DetailsDataWorkspace> update(@PathVariable(value = "id") Long id, @RequestBody UpdateDataWorkspace request);
}

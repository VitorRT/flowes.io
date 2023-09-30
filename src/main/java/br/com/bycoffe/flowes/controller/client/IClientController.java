package br.com.bycoffe.flowes.controller.client;

import br.com.bycoffe.flowes.models.client.dto.DetailsDataClient;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public interface IClientController {

    @Operation(
            summary = "Listagem de clientes.",
            description = "Listagem geral de todas os clientes cadastrados e ativos."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados dos clientes foram retornados.")
    }
    )
    ResponseEntity<PagedModel<EntityModel<ListingDataClient>>> search(@PageableDefault(size = 10) Pageable pagination);

    @Operation(
            summary = "Cadastro de cliente.",
            description = "Cadastro de um cliente para poder acessar todos os recursos da api. (Esta requisição não precisa de um token.)"
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "201", description = "O cliente foi criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")
    }
    )
    ResponseEntity<DetailsDataClient> create(@RequestBody @Valid RegisterUpdateDataClient request, BindingResult result);

    @Operation(
            summary = "Detalhamento de cliente.",
            description = "Detalhamento de um cliente cadastrado e ativo."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados do cliente foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    ResponseEntity<DetailsDataClient> show(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Deleção de cliente.",
            description = "Deleção de um cliente cadastrado e ativo. É preciso informar o id do cliente no path da requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "204", description = "O cliente foi deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Edição de cliente.",
            description = "Edição de um cliente cadastrado e ativo. É preciso informar o id do cliente no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Os dados do cliente foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    ResponseEntity<DetailsDataClient> update(@PathVariable(value = "id") Long id, @RequestBody RegisterUpdateDataClient request);
}

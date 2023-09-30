package br.com.bycoffe.flowes.controller.project;

import br.com.bycoffe.flowes.models.project.dto.DetailsDataProject;
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.project.dto.UpdateDataProject;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProjectController {
    @Operation(
            summary = "Listagem de projetos.",
            description = "Listagem geral de todas os projetos cadastrados e ativos."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Os dados dos projetos foram retornados.")
    }
    )
    ResponseEntity<PagedModel<EntityModel<ListingDataProject>>> search(@PageableDefault(size = 10) Pageable pagination);

    @Operation(
            summary = "Cadastro de projeto.",
            description = "Cadastro de um projeto. Para poder cadastrar é preciso informar o id da workspace."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "O projeto foi criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")
    }
    )
    ResponseEntity<DetailsDataProject> create(@RequestBody @Valid RegisterDataProject request, BindingResult result);

    @Operation(
            summary = "Detalhamento de projeto.",
            description = "Detalhamento de um projeto cadastrado e ativo. É preciso informar o id do projeto no path da requisição."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Os dados do projeto foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe um projeto com esse ID.")
    }
    )
    ResponseEntity<DetailsDataProject> show(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Deleção de projeto.",
            description = "Deleção de um projeto cadastrado e ativo. É preciso informar o id do projeto no path da requisição."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "O projeto foi deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não existe um projeto com esse ID.")
    }
    )
    ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id);

    @Operation(
            summary = "Edição de projeto.",
            description = "Edição de um projeto cadastrado e ativo. É preciso informar o id do projeto no path da requisição e um corpo na requisição."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Os dados do projeto foram retornados."),
            @ApiResponse(responseCode = "400", description = "Não existe um projeto com esse ID.")
    }
    )
    ResponseEntity<DetailsDataProject> update(@PathVariable(value = "id") Long id, @RequestBody UpdateDataProject request);
}
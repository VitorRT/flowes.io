package br.com.bycoffe.flowes.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
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
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.models.workspace.dto.DetailsDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/workspace")
@Tag(name = "Workspace 💻")
public class WorkspaceController {
    
    Logger log = LoggerFactory.getLogger(WorkspaceController.class);
    
    @Autowired
    WorkspaceRepository repository;

    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    PagedResourcesAssembler<ListingDataWorkspace> assembler;



    private Workspace getWorkspace(Long id) {
        return repository.findById(id).orElseThrow(() -> { 
            return new RestNotFoundException(
                "Nenhuma workspace com o id [ " + 
                id + 
                " ] foi encontrada."
                );
        });
    }

   
    @GetMapping
    @Operation(
        summary = "Listagem de workspaces.",
        description = "Listagem geral de todas as workspaces cadastradas e ativas."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados das workspaces foram retornados.")
    }
    )
    public PagedModel<EntityModel<ListingDataWorkspace>> search(
            @ParameterObject @PageableDefault(size = 10) Pageable pagination
        ) {
        log.info("[ Search ] Buscando Workspaces");
        Page<ListingDataWorkspace> workspaces = repository.findAllByCompleteFalse(pagination).map(ListingDataWorkspace::new);
        PagedModel<EntityModel<ListingDataWorkspace>> pagedModel = assembler.toModel(workspaces);

        return pagedModel;
    }


    @PostMapping
    @Operation(
        summary = "Cadastro de uma workspace.",
        description = "Cadastro de uma workspace. Para poder cadastrar é preciso informar o id do cliente."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "201", description = "A worskpace foi criada com sucesso."),   
        @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")   
    }
    )
    public ResponseEntity<DetailsDataWorkspace> create(
        @RequestBody @Valid RegisterDataWorkspace workspaceDTO,
        BindingResult result) {

        log.info("[ Create ] Cadastrando Workspace: " + workspaceDTO.name()); 
        
        Workspace workspace = new Workspace(workspaceDTO);
        repository.save(workspace);
        workspace.setClient(clientRepository.findById(workspaceDTO.client().getId()).get());
        DetailsDataWorkspace workspaceCreated = new DetailsDataWorkspace(workspace);

        return ResponseEntity.status(HttpStatus.CREATED).body(workspaceCreated);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhamento de workspace.",
        description = "Detalhamento de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados da workspace foram retornados."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataWorkspace> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Workspace: " + id);

        Workspace workspaceEncontrado = getWorkspace(id);
        DetailsDataWorkspace workspace = new DetailsDataWorkspace(workspaceEncontrado);

        return ResponseEntity.ok(workspace);
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deleção de workspace.",
        description = "Deleção de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "204", description = "A workspace foi deletada com sucesso."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataWorkspace> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Workspace: " + id);

        Workspace workspaceEncontrado = getWorkspace(id);

        repository.delete(workspaceEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Edição de workspace.",
        description = "Edição de uma workspace cadastrada e ativa. É preciso informar o id da workspace no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados da workspace foram retornados."),   
        @ApiResponse(responseCode = "400", description = "Não existe uma workspace com esse ID.")   
    }
    )
    public ResponseEntity<DetailsDataWorkspace> update(
        @PathVariable Long id, 
        @RequestBody UpdateDataWorkspace workspaceDTO) {
        log.info("[ Update ] Atualizando Workspace: " + id);

        Workspace workspaceEncontrado = getWorkspace(id);
        Workspace workspace = new Workspace(workspaceDTO);

        workspace.setId(id);
        workspace.setUpdatedAt(LocalDateTime.now());
        workspace.setClient(workspaceEncontrado.getClient());
        repository.save(workspace);
        
        DetailsDataWorkspace workspaceUpdated = new DetailsDataWorkspace(workspace);
        
        return ResponseEntity.ok(workspaceUpdated);
    }
}

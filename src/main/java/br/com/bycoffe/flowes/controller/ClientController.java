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
import org.springframework.security.crypto.password.PasswordEncoder;
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
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.DetailsDataClient;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import br.com.bycoffe.flowes.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/client")
@Tag(name = "Client 🙋🏾‍♂️")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientRepository repository;

    @Autowired
    PagedResourcesAssembler<ListingDataClient> assembler;

    @Autowired
    private PasswordEncoder encoder;
    

    /* Método privado para buscar o modelo Client no banco de dados. */
    private Client getClient(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RestNotFoundException("Nenhum cliente com o [ " +
                    id +
                    " ] foi encontrado!");
        });
    }

    
    @GetMapping
    @Operation(
        summary = "Listagem de clientes.",
        description = "Listagem geral de todas os clientes cadastrados e ativos."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados dos clientes foram retornados.")
    }
    )
    public PagedModel<EntityModel<ListingDataClient>> search(@PageableDefault(size = 10) Pageable pagination) {
        log.info("[ Search ] Buscando Clientes");
        Page<ListingDataClient> clients = repository.findAllByActiveTrue(pagination).map(ListingDataClient::new);
        PagedModel<EntityModel<ListingDataClient>> pagedModel = assembler.toModel(clients);

        return pagedModel;
    }

    @PostMapping
    @Operation(
        summary = "Cadastro de cliente.",
        description = "Cadastro de um cliente para poder acessar todos os recursos da api. (Esta requisição não precisa de um token.)"
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "201", description = "O cliente foi criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos.")
    }
    )
    public ResponseEntity<DetailsDataClient> create(
            @RequestBody @Valid RegisterUpdateDataClient clientDTO,
            BindingResult result) {

        log.info("[ Create ] Cadastrando Cliente: " + clientDTO.clientName());

        Client clientModel = new Client(clientDTO);
        clientModel.setSenha(encoder.encode(clientDTO.senha()));
        repository.save(clientModel);
        DetailsDataClient client = new DetailsDataClient(clientModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhamento de cliente.",
        description = "Detalhamento de um cliente cadastrado e ativo."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados do cliente foram retornados."),
        @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    public ResponseEntity<DetailsDataClient> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Cliente: " + id);

        Client client = getClient(id);
        client.toEntityModel();
        DetailsDataClient clienteDetalhado = new DetailsDataClient(client);

        return ResponseEntity.ok(clienteDetalhado);
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deleção de cliente.",
        description = "Deleção de um cliente cadastrado e ativo. É preciso informar o id do cliente no path da requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "204", description = "O cliente foi deletada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    public ResponseEntity<Void> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Cliente: " + id);

        Client clientEncontrado = getClient(id);

        repository.delete(clientEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Edição de cliente.",
        description = "Edição de um cliente cadastrado e ativo. É preciso informar o id do cliente no path da requisição e um corpo na requisição."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados do cliente foram retornados."),
        @ApiResponse(responseCode = "400", description = "Não existe um cliente com esse ID.")
    }
    )
    public ResponseEntity<DetailsDataClient> update(
            @PathVariable Long id,
            @RequestBody RegisterUpdateDataClient clientDTO) {

        log.info("[ Update ] Atualizando Cliente: " + id);

        getClient(id);

        Client client = new Client(clientDTO);

        client.setId(id);
        client.setUpdatedAt(LocalDateTime.now());
        repository.save(client);
        DetailsDataClient clientDetalhado = new DetailsDataClient(client);

        return ResponseEntity.ok(clientDetalhado);
    }
}

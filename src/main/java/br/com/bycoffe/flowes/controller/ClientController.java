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
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.repository.ClientRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    ClientRepository repository;


    /* Método privado para buscar o modelo Client no banco de dados. */
    private Client getClient(Long id) {
        return repository.findById(id).orElseThrow(() -> { 
            return new RestNotFoundException("Nenhum cliente com o [ " +
            id +
            " ] foi encontrado!"
            ); 
        });
    }



    @GetMapping
    public ResponseEntity<Page<ListingDataClient>> returnClient(@PageableDefault(size = 10) Pageable pagination) {
        log.info("[ Search ] Buscando Clientes"); 
        Page<ListingDataClient> pages = repository.findAllByActiveTrue(pagination).map(ListingDataClient::new);
        return ResponseEntity.ok(pages);
    }

    @PostMapping
    public ResponseEntity<Client> create(
        @RequestBody @Valid Client client, 
        BindingResult result) {

        log.info("[ Create ] Cadastrando Cliente: " + client); 

        repository.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Cliente: " + id);

        Client clientEncontrado = getClient(id);

        return ResponseEntity.ok(clientEncontrado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Client> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Cliente: " + id);

        Client clientEncontrado = getClient(id);

        repository.delete(clientEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(
        @PathVariable Long id, 
        @RequestBody Client cliente
        ) {
            
        log.info("[ Update ] Atualizando Cliente: " + id);

        getClient(id);

        cliente.setId(id);
        cliente.setUpdatedAt(LocalDateTime.now());
        repository.save(cliente);
        
        return ResponseEntity.ok(cliente);
    }
}

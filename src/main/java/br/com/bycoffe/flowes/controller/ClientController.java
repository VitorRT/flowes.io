package br.com.bycoffe.flowes.controller;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.bycoffe.flowes.models.Client;
import br.com.bycoffe.flowes.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    ClientRepository repository;



    @GetMapping
    public List<Client> returnClient() {

        log.info("[ Search ] Buscando Clientes"); 

        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {

        log.info("[ Create ] Cadastrando Cliente: " + client); 

        repository.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Cliente: " + id);

        Optional<Client> clientEncontrado = repository.findById(id);

        if(clientEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(clientEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Client> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Cliente: " + id);

        Optional<Client> clientEncontrado = repository.findById(id);

        if(clientEncontrado.isEmpty()) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repository.delete(clientEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client cliente) {
        log.info("[ Update ] Atualizando Cliente: " + id);

        Optional<Client> clientEncontrado = repository.findById(id);

        if(clientEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
       // BeanUtils.copyProperties(clientEncontrado, clienteAtualizado, "id");

        cliente.setId(id);
        repository.save(cliente);
        
        return ResponseEntity.ok(cliente);
    }
}

package br.com.bycoffe.flowes.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.Client;

@RestController
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);
    List<Client> listaClientes = new ArrayList<>();

    @GetMapping("/api/v1/client")
    public List<Client> returnClient() {
        log.info("[ Search ] Buscando Clientes"); 
        return listaClientes;
    }

    @PostMapping("/api/v1/client")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        log.info("[ Create ] Cadastrando Cliente: " + client); 
        listaClientes.add(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/api/v1/client/{id}")
    public ResponseEntity<Client> show(@PathVariable Long id) {
        log.info("[ Show ] Buscando Cliente: " + id);
        Optional<Client> clientEncontrado = listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst();

        if(clientEncontrado.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(clientEncontrado.get());
    }

    @DeleteMapping("/api/v1/client/{id}")
    public ResponseEntity<Client> destroy(@PathVariable Long id) {
        log.info("[ Destroy ] Apagando Cliente: " + id);
        Optional<Client> clientEncontrado = listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(clientEncontrado.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        listaClientes.remove(clientEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/v1/client/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client cliente) {
        log.info("[ Update ] Atualizando Cliente: " + id);
        Optional<Client> clientEncontrado = listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(clientEncontrado.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

      
        listaClientes.remove(clientEncontrado.get());
        cliente.setId(id);
        listaClientes.add(cliente);
        return ResponseEntity.ok(cliente);
    }
}

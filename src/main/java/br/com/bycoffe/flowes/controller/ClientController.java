package br.com.bycoffe.flowes.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.Client;

@RestController
public class ClientController {

    @GetMapping("/api/v1/client")
    public Client returnClient() {
        return new Client(1l,"Victor", "vitu.lindo@gmail.com", "teste123", LocalDate.now());
    }
}

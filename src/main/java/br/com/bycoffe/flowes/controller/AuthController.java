package br.com.bycoffe.flowes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.client.dto.AuthDataClient;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity<Object> login (@RequestBody @Valid AuthDataClient credential) {
        manager.authenticate(credential.toAuthentication());
        return ResponseEntity.ok().build();
    }
}

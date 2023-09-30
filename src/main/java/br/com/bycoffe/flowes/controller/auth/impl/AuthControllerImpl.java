package br.com.bycoffe.flowes.controller.auth.impl;

import br.com.bycoffe.flowes.controller.auth.IAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.dto.Token;
import br.com.bycoffe.flowes.models.client.dto.AuthDataClient;
import br.com.bycoffe.flowes.service.authentication.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth 🔐")
public class AuthControllerImpl implements IAuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Token> login (AuthDataClient credential) {
        manager.authenticate(credential.toAuthentication());
        var token = tokenService.generateToken(credential);
        return ResponseEntity.ok().body(token);
    }
}

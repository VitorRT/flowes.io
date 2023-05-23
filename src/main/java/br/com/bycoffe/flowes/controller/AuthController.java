package br.com.bycoffe.flowes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.dto.Token;
import br.com.bycoffe.flowes.models.client.dto.AuthDataClient;
import br.com.bycoffe.flowes.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth 🔐")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    @Operation(
        summary = "Login",
        description = "Autenticação para poder receber um token JWT e usar os recursos da api. (Esta requisição não precisa de um token)."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Cliente autenticado com sucesso."),
        @ApiResponse(responseCode = "403", description = "Os dados de autenticação são iválidos.")
    }
    )
    public ResponseEntity<Token> login (@RequestBody @Valid AuthDataClient credential) {
        manager.authenticate(credential.toAuthentication());
        var token = tokenService.generateToken(credential);
        return ResponseEntity.ok().body(token);
    }
}

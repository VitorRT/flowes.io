package br.com.bycoffe.flowes.controller.auth;

import br.com.bycoffe.flowes.dto.Token;
import br.com.bycoffe.flowes.models.client.dto.AuthDataClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthController {
    @Operation(
            summary = "Login",
            description = "Autenticação para poder receber um token JWT e usar os recursos da api. (Esta requisição não precisa de um token)."
    )
    @ApiResponses( {
            @ApiResponse(responseCode = "200", description = "Cliente autenticado com sucesso."),
            @ApiResponse(responseCode = "403", description = "Os dados de autenticação são iválidos.")
    }
    )
    ResponseEntity<Token> login (@RequestBody @Valid AuthDataClient credential);
}

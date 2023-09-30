package br.com.bycoffe.flowes.service.authentication;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.bycoffe.flowes.dto.Token;
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.AuthDataClient;
import br.com.bycoffe.flowes.repository.ClientRepository;

@Service
public class TokenService {

    @Autowired
    private ClientRepository clientRepository;

    @Value("${jwt.secret}")
    private String secret;
    
    public Token generateToken(AuthDataClient client) {

       

        Algorithm alg = Algorithm.HMAC256("secret");
        var token = JWT.create()
                    .withSubject(client.email())
                    .withIssuer("Flowes")
                    .withExpiresAt(Instant.now().plus(20, ChronoUnit.MINUTES))
                    .sign(alg)
                    ;
        return new Token(token, "JWT", "Bearer");
    }

    public Client getClientByToken(String token) {
        Algorithm alg = Algorithm.HMAC256("secret");
        var email = JWT.require(alg)
                    .withIssuer("Flowes")
                    .build()
                    .verify(token)
                    .getSubject()
                    ;

        return clientRepository.findByEmail(email)
        .orElseThrow(() -> new JWTVerificationException("Usuário inválido"));
    }
}

package br.com.bycoffe.flowes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
      return new OpenAPI()
             .info(new Info()
                .title("Flowes Rest API 🌻")
                .version("v1")
                .contact(new Contact().name("Victor Sousa Barberino 🙋🏾‍♂️").email("vitu.barberino@gmail.com"))
                .description("API Reste de acesso para o sistema de controle de tarefas!")
             )
             .components(new Components()
             .addSecuritySchemes("bearer-key",
             new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
   }
}

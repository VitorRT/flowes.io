package br.com.bycoffe.flowes.models.client;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bycoffe.flowes.controller.ClientController;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(uniqueConstraints = @UniqueConstraint( columnNames={ "email" } ) )
@Data @EqualsAndHashCode 
public class Client{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    private String email;

    private String senha;

    private LocalDate dataNascimento;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean active;

    
    protected Client() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }


    public Client(Long id) {
        this.id = id;
    }


    public Client(RegisterUpdateDataClient clientDTO) {
        this.clientName = clientDTO.clientName();
        this.email = clientDTO.email();
        this.senha = clientDTO.senha();
        this.dataNascimento = clientDTO.dataNascimento();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    /* Usar este método futuramente quando formos trabalhar com soft delete. */
    public void turnOffAccount() {
        this.active = false;
    }

    public EntityModel<Client> toEntityModel() {
        return EntityModel.of(this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).destroy(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).search(Pageable.unpaged())).withRel("all")
        );
    }

    
}

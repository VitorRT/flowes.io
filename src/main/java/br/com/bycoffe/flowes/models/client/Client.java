package br.com.bycoffe.flowes.models.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bycoffe.flowes.controller.client.impl.ClientControllerImpl;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Data
@EqualsAndHashCode
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).show(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).destroy(id))
                        .withRel("delete"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).search(Pageable.unpaged()))
                        .withRel("all"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

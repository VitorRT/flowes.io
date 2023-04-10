package br.com.bycoffe.flowes.models.client;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(uniqueConstraints = @UniqueConstraint( columnNames={ "email" } ) )
public class Client {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String client_name;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotNull
    @PastOrPresent
    private LocalDate data_nascimento;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private Boolean active;

    
    protected Client() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public Client(Long id, String client_name, String email, String senha, LocalDate data_nascimento) {
        this.id = id;
        this.client_name = client_name;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClient_name() {
        return client_name;
    }
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    /* Usar este método futuramente quando formos trabalhar com soft delete. */
    public void turnOffAccount() {
        this.active = false;
    }
    


    @Override
    public String toString() {
        return "Client [id=" + id + ", client_name=" + client_name + ", email=" + email + ", senha=" + senha
                + ", data_nascimento=" + data_nascimento + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + "]";
    }

    
}

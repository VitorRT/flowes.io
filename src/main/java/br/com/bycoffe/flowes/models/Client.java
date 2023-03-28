package br.com.bycoffe.flowes.models;

import java.time.LocalDate;

public class Client {
    private Long id;
    private String client_name;
    private String email;
    private String senha;
    private LocalDate data_nascimento;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    
    

    public Client(Long id, String client_name, String email, String senha, LocalDate data_nascimento) {
        this.id = id;
        this.client_name = client_name;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Client [id=" + id + ", client_name=" + client_name + ", email=" + email + ", senha=" + senha
                + ", data_nascimento=" + data_nascimento + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + "]";
    }

    
}

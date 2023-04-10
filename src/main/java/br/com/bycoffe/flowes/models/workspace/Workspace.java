package br.com.bycoffe.flowes.models.workspace;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Workspace {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @FutureOrPresent
    private LocalDateTime deadline;

    @NotBlank
    private String description;

    @NotBlank
    private String workspace_photo;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @Column(name = "complete")
    @NotNull
    private Boolean complete;



    protected Workspace() { 
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Workspace(Long id, String name, LocalDateTime deadline, String description, String workspace_photo) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.workspace_photo = workspace_photo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getWorkspace_photo() {
        return workspace_photo;
    }
    public void setWorkspace_photo(String workspace_photo) {
        this.workspace_photo = workspace_photo;
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
    public Boolean getComplete() {
        return complete;
    }
    public void seComplete(Boolean complete) {
        this.complete = complete;
    }


    public void completeThis() {
        this.complete = true;
    }
    
}

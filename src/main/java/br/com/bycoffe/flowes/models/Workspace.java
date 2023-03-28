package br.com.bycoffe.flowes.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workspace {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate deadline;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private String workspace_photo;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = false, name = "its_complete")
    private Boolean itsComplete;

    protected Workspace() { 
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Workspace(Long id, String name, LocalDate deadline, String description, String workspace_photo) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.workspace_photo = workspace_photo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.itsComplete = false;
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
    public LocalDate getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDate deadline) {
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
    public Boolean getItsComplete() {
        return itsComplete;
    }
    public void setItsComplete(Boolean itsComplete) {
        this.itsComplete = itsComplete;
    }
}

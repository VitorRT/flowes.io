package br.com.bycoffe.flowes.models;

import java.time.LocalDate;

public class Workspace {
    private Long id;
    private String name;
    private LocalDate deadline;
    private String description;
    private String workspace_photo;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean itsComplete;


    public Workspace(Long id, String name, LocalDate deadline, String description, String workspace_photo) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.workspace_photo = workspace_photo;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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
    public Boolean getItsComplete() {
        return itsComplete;
    }
    public void setItsComplete(Boolean itsComplete) {
        this.itsComplete = itsComplete;
    }
}

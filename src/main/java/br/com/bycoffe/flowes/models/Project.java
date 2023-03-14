package br.com.bycoffe.flowes.models;

import java.time.LocalDate;

import br.com.bycoffe.flowes.deadline.Deadline;

public class Project {
    private Long id;
    private String name;
    private Deadline deadline;
    private String label;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean itsComplete;


    public Project(Long id, String name, Deadline deadline, String label, String description) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.label = label;
        this.description = description;
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


    public Deadline getDeadline() {
        return deadline;
    }


    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
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

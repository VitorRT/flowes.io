package br.com.bycoffe.flowes.models;

import java.time.LocalDate;

public class Categorie {
    private Long id;
    private String name;
    private LocalDate task_day;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean itsComplete;



    public Categorie(Long id, String name, LocalDate task_day) {
        this.id = id;
        this.name = name;
        this.task_day = task_day;
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

    public LocalDate getTask_day() {
        return task_day;
    }

    public void setTask_day(LocalDate task_day) {
        this.task_day = task_day;
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

package br.com.bycoffe.flowes.models;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.deadline.Deadline;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Deadline deadline;

    @Column(nullable = false)
    private String label;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, name="its_complete")
    private Boolean itsComplete;

    protected Project() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.itsComplete = false;
    }

    public Project(Long id, String name, Deadline deadline, String label, String description) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.label = label;
        this.description = description;
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

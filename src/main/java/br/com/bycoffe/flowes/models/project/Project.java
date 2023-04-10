package br.com.bycoffe.flowes.models.project;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.utils.deadline.Deadline;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Embedded
    private Deadline deadline;

    @NotBlank
    private String label;

    @NotBlank
    private String description;

  
    @NotNull
    private LocalDateTime createdAt;


    @NotNull
    private LocalDateTime updatedAt;

    @Column(name="its_complete")
    @NotNull
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

    
    public void completeThis() {
        this.itsComplete = true;
    }

}

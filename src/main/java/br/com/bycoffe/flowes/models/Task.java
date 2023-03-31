package br.com.bycoffe.flowes.models;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String task_label;

    @Embedded
    private DeadlineTask deadline_task;

    @Embedded
    private Category category;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, name = "is_complete")
    private Boolean isComplete;
    

    public Task() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isComplete = false;
    }
    
    public Task(Long id, String name, String role, String task_label, DeadlineTask deadline_task, Category category) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.task_label = task_label;
        this.deadline_task = deadline_task;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isComplete = false;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTask_label() {
        return task_label;
    }

    public void setTask_label(String task_label) {
        this.task_label = task_label;
    }

    public DeadlineTask getDeadline_task() {
        return deadline_task;
    }

    public void setDeadline_task(DeadlineTask deadline_task) {
        this.deadline_task = deadline_task;
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

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplet(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}

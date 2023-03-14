package br.com.bycoffe.flowes.models;

import java.time.LocalDate;

import br.com.bycoffe.flowes.deadline.DeadlineTask;

public class Task {

    private Long id;
    private String name;
    private String role;
    private String task_label;
    private DeadlineTask deadline_task;
    
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean check;
    
    
    public Task(Long id, String name, String role, String task_label, DeadlineTask deadline_task) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.task_label = task_label;
        this.deadline_task = deadline_task;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.check = false;
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

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
    
}

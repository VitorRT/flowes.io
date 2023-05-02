package br.com.bycoffe.flowes.models.task;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bycoffe.flowes.controller.TaskContoller;
import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.task.dto.UpdateDataTask;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data @EqualsAndHashCode
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Project project;

    private String name;

    private String role;

    private String taskLabel;

    @Embedded
    private DeadlineTask deadlineTask;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean complete;
    

    public Task() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }
    
    public Task(RegisterDataTask taskDTO) {
        this.project = taskDTO.project();
        this.name = taskDTO.name();
        this.role = taskDTO.role();
        this.taskLabel = taskDTO.taskLabel() == null ? "#B4B4B4" : taskDTO.taskLabel();
        this.deadlineTask = taskDTO.deadlineTask();
        this.category = taskDTO.category();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Task(UpdateDataTask taskDTO) {
        this.name = taskDTO.name();
        this.role = taskDTO.role();
        this.taskLabel = taskDTO.taskLabel();
        this.deadlineTask = taskDTO.deadlineTask();
        this.category = taskDTO.category();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public void completeThis() {
        this.complete = true;
    }

    public EntityModel<Task> toEntityModel() {
        return EntityModel.of(this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskContoller.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskContoller.class).destroy(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskContoller.class).search(Pageable.unpaged())).withRel("all")
        );
    }

}

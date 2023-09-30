package br.com.bycoffe.flowes.models.project;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bycoffe.flowes.controller.project.impl.ProjectControllerImpl;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.project.dto.UpdateDataProject;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.utils.deadline.Deadline;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data @EqualsAndHashCode
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workspace workspace;

    private String name;

    @Embedded
    private Deadline deadline;

    private String label;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean complete;


    protected Project() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project(RegisterDataProject projectDTO) {
        this.workspace = projectDTO.workspace();
        this.name = projectDTO.name();
        this.deadline = projectDTO.deadline();
        this.label = projectDTO.label();
        this.description = projectDTO.description() == null ? "Meu projeto maravilhoso 😊" : projectDTO.description();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Project(UpdateDataProject projectDTO) {
        this.name = projectDTO.name();
        this.deadline = projectDTO.deadline();
        this.label = projectDTO.label();
        this.description = projectDTO.description();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public void completeThis() {
        this.complete = true;
    }

    public EntityModel<Project> toEntityModel() {
        return EntityModel.of(this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectControllerImpl.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectControllerImpl.class).destroy(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectControllerImpl.class).search(Pageable.unpaged())).withRel("all")
        );
    }

}

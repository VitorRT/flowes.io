package br.com.bycoffe.flowes.models.workspace;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bycoffe.flowes.controller.WorkspaceController;
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Data @EqualsAndHashCode
public class Workspace {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String name;

    private LocalDateTime deadline;

    private String description;

    @Column(name="workspace_img")
    private String workspaceImage;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean complete;


    protected Workspace() { 
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Workspace(Long id) {
        this.id = id;
    }

    public Workspace(RegisterDataWorkspace workspaceDTO) {
        this.client = workspaceDTO.client();
        this.name = workspaceDTO.name();
        this.deadline = workspaceDTO.deadline();
        this.description = workspaceDTO.description() == null ? "Minha área de trabalho!" : workspaceDTO.description();
        this.workspaceImage = workspaceDTO.workspaceImage() == null ? "default_unknow.png" : workspaceDTO.workspaceImage();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }

    public Workspace(UpdateDataWorkspace workspaceDTO) {
        this.name = workspaceDTO.name();
        this.deadline = workspaceDTO.deadline();
        this.description = workspaceDTO.description();
        this.workspaceImage = workspaceDTO.workspaceImage();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.complete = false;
    }


    public void completeThis() {
        this.complete = true;
    }


    public EntityModel<Workspace> toEntityModel() {
        return EntityModel.of(this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkspaceController.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkspaceController.class).destroy(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkspaceController.class).search(Pageable.unpaged())).withRel("all")
        );
    }
}

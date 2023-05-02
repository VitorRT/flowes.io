package br.com.bycoffe.flowes.models.project.dto;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.workspace.dto.RelationDataWorkspace;
import br.com.bycoffe.flowes.utils.deadline.Deadline;

public record DetailsDataProject(
    Long id,
    RelationDataWorkspace workspace,
    String name,
    Deadline deadline,
    String label,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Links links
) {
    public DetailsDataProject(Project project) {
        this(
            project.getId(),
            new RelationDataWorkspace(project.getWorkspace()),
            project.getName(),
            project.getDeadline(),
            project.getLabel(),
            project.getDescription(),
            project.getCreatedAt(),
            project.getUpdatedAt(),
            project.toEntityModel().getLinks()
        );
    }
}

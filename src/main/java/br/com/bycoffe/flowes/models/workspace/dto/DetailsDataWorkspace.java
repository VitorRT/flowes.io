package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.client.dto.RelationDataClient;
import br.com.bycoffe.flowes.models.workspace.Workspace;

public record DetailsDataWorkspace(
    Long id,
    RelationDataClient client,
    String name,
    LocalDateTime deadline,
    String description,
    String workspaceImage,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public DetailsDataWorkspace(Workspace workspace) {
        this(
            workspace.getId(),
            new RelationDataClient(workspace.getClient()),
            workspace.getName(),
            workspace.getDeadline(),
            workspace.getDescription(),
            workspace.getWorkspaceImage(),
            workspace.getCreatedAt(),
            workspace.getUpdatedAt()
        );
    }
}

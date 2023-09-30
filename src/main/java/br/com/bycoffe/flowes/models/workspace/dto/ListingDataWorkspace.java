package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

import br.com.bycoffe.flowes.models.client.dto.RelationDataClient;
import br.com.bycoffe.flowes.models.workspace.Workspace;

public record ListingDataWorkspace(
        Long id,
        RelationDataClient client,
        String name,
        String workspaceImage,
        LocalDateTime createdAt,
        Links links) {

    public ListingDataWorkspace(Workspace workspace) {
        this(
                workspace.getId(),
                new RelationDataClient(workspace.getClient()),  
                workspace.getName(),
                workspace.getWorkspaceImage(),
                workspace.getCreatedAt(),
                workspace.toEntityModel().getLinks());
    }
}

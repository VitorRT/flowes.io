package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.client.dto.RelationDataClient;
import br.com.bycoffe.flowes.models.workspace.Workspace;

public record ListingDataWorkspace(
    Long id, 
    RelationDataClient client,
    String name, 
    LocalDateTime deadline,
    String workspaceImage
    ) {
    
        public ListingDataWorkspace(Workspace workspace) {
            this(
                workspace.getId(),
                new RelationDataClient(workspace.getClient()),
                workspace.getName(),
                workspace.getDeadline(),
                workspace.getWorkspaceImage()
            );
        }
}

package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.workspace.Workspace;

public record ListingDataWorkspace(
    Long id, 
    String name, 
    LocalDateTime deadline,
    String description, 
    String workspaceImage, 
    LocalDateTime createdAt,
    LocalDateTime updatedAt
    
    ) {
    
        public ListingDataWorkspace(Workspace workspace) {
            this(
                workspace.getId(),
                workspace.getName(),
                workspace.getDeadline(),
                workspace.getDescription(),
                workspace.getWorkspace_photo(),
                workspace.getCreatedAt(),
                workspace.getUpdatedAt()
            );
        }
}

package br.com.bycoffe.flowes.models.project.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.utils.deadline.Deadline;

public record ListingDataProject(
        Long id, 
        String nameProject, 
        Deadline deadline, 
        String label, 
        String description, 
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {

    public ListingDataProject(Project project) {
        this(
            project.getId(),
            project.getName(),
            project.getDeadline(),
            project.getLabel(),
            project.getDescription(),
            project.getCreatedAt(),
            project.getUpdatedAt()
        );
    }
    
}

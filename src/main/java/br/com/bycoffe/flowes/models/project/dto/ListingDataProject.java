package br.com.bycoffe.flowes.models.project.dto;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.workspace.dto.RelationDataWorkspace;
import br.com.bycoffe.flowes.utils.deadline.Deadline;

public record ListingDataProject(
        Long id, 
        RelationDataWorkspace workspace,
        String nameProject, 
        Deadline deadline, 
        String label
    ) {

    public ListingDataProject(Project project) {
        this(
            project.getId(),
            new RelationDataWorkspace(project.getWorkspace()),
            project.getName(),
            project.getDeadline(),
            project.getLabel()
        );
    }
    
}

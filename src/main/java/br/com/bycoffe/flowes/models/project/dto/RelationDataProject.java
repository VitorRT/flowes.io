package br.com.bycoffe.flowes.models.project.dto;

import br.com.bycoffe.flowes.models.project.Project;

public record RelationDataProject( Long id, String projectName ) {

    public RelationDataProject(Project project) {
        this(project.getId(), project.getName());
    }

}

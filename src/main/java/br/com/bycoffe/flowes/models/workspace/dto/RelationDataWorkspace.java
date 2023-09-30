package br.com.bycoffe.flowes.models.workspace.dto;

import br.com.bycoffe.flowes.models.workspace.Workspace;

public record RelationDataWorkspace( Long id, String workspaceName ) { 

    public RelationDataWorkspace(Workspace workspace) {
        this( workspace.getId(), workspace.getName() );
    }
    
}

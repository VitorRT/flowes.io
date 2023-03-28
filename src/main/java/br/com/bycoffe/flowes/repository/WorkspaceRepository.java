package br.com.bycoffe.flowes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long>{
    
}

package br.com.bycoffe.flowes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.workspace.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long>{
    
    public Page<Workspace> findAllByCompleteTrue(Pageable pagination);

}

package br.com.bycoffe.flowes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

    public Page<Project> findAllByActiveTrue(Pageable pagination);
    
}

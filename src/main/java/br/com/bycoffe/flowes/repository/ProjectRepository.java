package br.com.bycoffe.flowes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}

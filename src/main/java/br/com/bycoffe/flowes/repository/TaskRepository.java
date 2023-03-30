package br.com.bycoffe.flowes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}

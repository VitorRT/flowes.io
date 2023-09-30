package br.com.bycoffe.flowes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByCompleteFalse(Pageable pagination);
    
}

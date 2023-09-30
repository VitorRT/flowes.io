package br.com.bycoffe.flowes.models.task.dto;

import org.springframework.hateoas.Links;

import br.com.bycoffe.flowes.models.project.dto.RelationDataProject;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;

public record ListingDataTask(
    Long id, 
    RelationDataProject project,
    String name,
    String role,
    String taskLabel,
    DeadlineTask deadlineTask,
    Category category,
    Links link
    ) {
    
        public ListingDataTask(Task task) {
            this(
                task.getId(),
                new RelationDataProject(task.getProject()),
                task.getName(),
                task.getRole(),
                task.getTaskLabel(),
                task.getDeadlineTask(),
                task.getCategory(),
                task.toEntityModel().getLinks()
            );
        }
}

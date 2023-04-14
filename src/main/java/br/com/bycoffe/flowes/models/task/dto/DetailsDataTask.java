package br.com.bycoffe.flowes.models.task.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.project.dto.RelationDataProject;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;

public record DetailsDataTask(
    Long id,
    RelationDataProject project,
    String name,
    String role,
    String task_label,
    DeadlineTask deadline_task,
    Category category,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    
    public DetailsDataTask(Task task) {
        this(
            task.getId(),
            new RelationDataProject(task.getProject()),
            task.getName(),
            task.getRole(),
            task.getTaskLabel(),
            task.getDeadlineTask(),
            task.getCategory(),
            task.getCreatedAt(),
            task.getUpdatedAt()
        );
    }
}

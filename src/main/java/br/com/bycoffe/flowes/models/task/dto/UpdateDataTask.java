package br.com.bycoffe.flowes.models.task.dto;

import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;

public record UpdateDataTask(
    
    @NotBlank
    String name,
        
    @NotBlank
    String role,
       
    String taskLabel,

    @Embedded
    DeadlineTask deadlineTask,

    @Embedded
    Category category

) { }

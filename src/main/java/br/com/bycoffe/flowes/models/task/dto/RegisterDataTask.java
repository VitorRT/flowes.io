package br.com.bycoffe.flowes.models.task.dto;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDataTask(

    @NotNull
    Project project,
    
    @NotBlank
    String name,
        
    @NotBlank
    String role,
       
    String taskLabel,

    @NotNull
    @Embedded
    DeadlineTask deadlineTask,

    @NotNull
    @Embedded
    Category category

) { }

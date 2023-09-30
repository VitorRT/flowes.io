package br.com.bycoffe.flowes.models.project.dto;

import br.com.bycoffe.flowes.utils.deadline.Deadline;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDataProject(

    @NotBlank
    String name,

    @NotNull
    Deadline deadline,

    @NotBlank
    String label,

    String description
    
) { }

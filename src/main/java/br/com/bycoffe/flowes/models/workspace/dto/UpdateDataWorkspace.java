package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDataWorkspace(
    @NotBlank
    String name,

    String description,

    String workspaceImage

) { }

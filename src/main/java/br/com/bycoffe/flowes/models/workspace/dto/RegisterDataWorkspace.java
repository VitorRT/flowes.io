package br.com.bycoffe.flowes.models.workspace.dto;

import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.client.Client;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDataWorkspace(

    @NotNull
    Client client,

    @NotBlank
    String name,

    String description,

    String workspaceImage

) { }

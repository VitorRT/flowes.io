package br.com.bycoffe.flowes.models.client.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record RegisterUpdateDataClient(
    @NotBlank
    String clientName,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String senha,

    @NotNull
    @PastOrPresent
    LocalDate dataNascimento
) { };

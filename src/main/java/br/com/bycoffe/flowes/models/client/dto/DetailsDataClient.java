package br.com.bycoffe.flowes.models.client.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.client.Client;

public record DetailsDataClient(
    Long id, 
    String clientName, 
    String email,
    LocalDate dataNascimento,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) { 

    public DetailsDataClient(Client client) {
        this(
            client.getId(),
            client.getClientName(),
            client.getEmail(),
            client.getDataNascimento(),
            client.getCreatedAt(),
            client.getUpdatedAt()
        );
    }
}

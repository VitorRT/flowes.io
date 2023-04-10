package br.com.bycoffe.flowes.models.client.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.bycoffe.flowes.models.client.Client;

public record ListingDataClient(Long id, String clientName, String email, LocalDate dataNascimento, LocalDateTime createdAt, LocalDateTime updatedAt) {

    public ListingDataClient(Client client) {
        this(
            client.getId(), 
            client.getClient_name(), 
            client.getEmail(), 
            client.getData_nascimento(), 
            client.getCreatedAt(), 
            client.getUpdatedAt()
            );
    }
}

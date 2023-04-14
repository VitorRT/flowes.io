package br.com.bycoffe.flowes.models.client.dto;


import br.com.bycoffe.flowes.models.client.Client;

public record ListingDataClient(Long id, String clientName, String email) {

    public ListingDataClient(Client client) {
        this(
            client.getId(), 
            client.getClientName(), 
            client.getEmail()
            );
    }
}

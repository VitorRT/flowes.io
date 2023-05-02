package br.com.bycoffe.flowes.models.client.dto;


import org.springframework.hateoas.Links;

import br.com.bycoffe.flowes.models.client.Client;

public record ListingDataClient(Long id, String clientName, String email, Links links) {

    public ListingDataClient(Client client) {
        this(
            client.getId(), 
            client.getClientName(), 
            client.getEmail(),
            client.toEntityModel().getLinks()
        );
    }
}

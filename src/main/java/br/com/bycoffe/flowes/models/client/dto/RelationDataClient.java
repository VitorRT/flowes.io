package br.com.bycoffe.flowes.models.client.dto;

import br.com.bycoffe.flowes.models.client.Client;

public record RelationDataClient( Long id,String clientName ) {

    public RelationDataClient(Client client) {
        this(client.getId(), client.getClientName());
    }
    
} 

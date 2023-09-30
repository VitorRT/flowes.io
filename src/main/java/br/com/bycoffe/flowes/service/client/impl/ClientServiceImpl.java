package br.com.bycoffe.flowes.service.client.impl;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.DetailsDataClient;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.service.client.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private PagedResourcesAssembler<ListingDataClient> assembler;

    @Autowired
    private PasswordEncoder encoder;

    private Client getClient(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RestNotFoundException("Nenhum cliente com o [ " +
                    id +
                    " ] foi encontrado!");
        });
    }

    @Override
    public PagedModel<EntityModel<ListingDataClient>> search(Pageable pagination) {
        log.info("[ Search ] Buscando Clientes");
        Page<ListingDataClient> clients = repository.findAllByActiveTrue(pagination).map(ListingDataClient::new);
        PagedModel<EntityModel<ListingDataClient>> pagedModel = assembler.toModel(clients);

        return pagedModel;
    }

    @Override
    public DetailsDataClient create(RegisterUpdateDataClient request) {
        log.info("[ Create ] Cadastrando Cliente: " + request.clientName());
        Client clientModel = new Client(request);
        clientModel.setSenha(encoder.encode(request.senha()));
        repository.save(clientModel);
        DetailsDataClient client = new DetailsDataClient(clientModel);

        return client;
    }

    @Override
    public DetailsDataClient show(Long id) {
        log.info("[ Show ] Buscando Cliente: " + id);
        Client client = getClient(id);
        client.toEntityModel();
        DetailsDataClient clienteDetalhado = new DetailsDataClient(client);

        return clienteDetalhado;
    }

    @Override
    public void destroy(Long id) {
        log.info("[ Destroy ] Apagando Cliente: " + id);
        Client clientEncontrado = getClient(id);
        repository.delete(clientEncontrado);
    }

    @Override
    public DetailsDataClient update(RegisterUpdateDataClient request, Long id) {
        log.info("[ Update ] Atualizando Cliente: " + id);
        getClient(id);
        Client client = new Client(request);
        client.setId(id);
        client.setUpdatedAt(LocalDateTime.now());
        repository.save(client);
        DetailsDataClient clientDetalhado = new DetailsDataClient(client);

        return clientDetalhado;
    }

}

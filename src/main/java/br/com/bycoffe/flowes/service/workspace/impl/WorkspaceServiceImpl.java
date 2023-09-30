package br.com.bycoffe.flowes.service.workspace.impl;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.models.workspace.dto.DetailsDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import br.com.bycoffe.flowes.service.workspace.IWorkspaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class WorkspaceServiceImpl implements IWorkspaceService {

    @Autowired
    PagedResourcesAssembler<ListingDataWorkspace> assembler;

    @Autowired
    WorkspaceRepository repository;

    @Autowired
    ClientRepository clientRepository;

    private Workspace getWorkspace(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new RestNotFoundException(
                    "Nenhuma workspace com o id [ " +
                            id +
                            " ] foi encontrada."
            );
        });
    }

    private Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> {
            return new RestNotFoundException(
                    "Nenhum cliente com o id [ " +
                            id +
                            " ] foi encontrado."
            );
        });
    }


    @Override
    public PagedModel<EntityModel<ListingDataWorkspace>> search(Pageable pagination) {
        log.info("[ Search ] Buscando Workspaces");
        Page<ListingDataWorkspace> workspaces = repository.findAllByCompleteFalse(pagination).map(ListingDataWorkspace::new);
        PagedModel<EntityModel<ListingDataWorkspace>> pagedModel = assembler.toModel(workspaces);

        return pagedModel;
    }

    @Override
    public DetailsDataWorkspace create(RegisterDataWorkspace request) {
        log.info("[ Create ] Cadastrando Workspace: " + request.name());
        Workspace workspace = new Workspace(request);
        repository.save(workspace);
        workspace.setClient(getClient(request.client().getId()));
        DetailsDataWorkspace workspaceCreated = new DetailsDataWorkspace(workspace);

        return workspaceCreated;
    }

    @Override
    public DetailsDataWorkspace show(Long id) {
        log.info("[ Show ] Buscando Workspace: " + id);
        Workspace workspaceEncontrada = getWorkspace(id);
        DetailsDataWorkspace workspace = new DetailsDataWorkspace(workspaceEncontrada);

        return workspace;
    }

    @Override
    public void destroy(Long id) {
        log.info("[ Destroy ] Apagando Workspace: " + id);
        Workspace workspaceEncontrado = getWorkspace(id);
        repository.delete(workspaceEncontrado);
    }

    @Override
    public DetailsDataWorkspace update(Long id, UpdateDataWorkspace request) {
        log.info("[ Update ] Atualizando Workspace: " + id);
        Workspace workspaceEncontrado = getWorkspace(id);
        Workspace workspace = new Workspace(request);
        workspace.setId(id);
        workspace.setUpdatedAt(LocalDateTime.now());
        workspace.setClient(workspaceEncontrado.getClient());
        repository.save(workspace);
        DetailsDataWorkspace workspaceUpdated = new DetailsDataWorkspace(workspace);

        return workspaceUpdated;
    }
}

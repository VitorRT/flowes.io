package br.com.bycoffe.flowes.service.workspace;

import br.com.bycoffe.flowes.models.workspace.dto.DetailsDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IWorkspaceService {
    PagedModel<EntityModel<ListingDataWorkspace>> search(Pageable pagination);
    DetailsDataWorkspace create(RegisterDataWorkspace request);
    DetailsDataWorkspace show(Long id);
    void destroy(Long id);
    DetailsDataWorkspace update(Long id, UpdateDataWorkspace request);

}

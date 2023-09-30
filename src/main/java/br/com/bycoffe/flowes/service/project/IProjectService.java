package br.com.bycoffe.flowes.service.project;

import br.com.bycoffe.flowes.models.project.dto.DetailsDataProject;
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.project.dto.UpdateDataProject;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IProjectService {
    PagedModel<EntityModel<ListingDataProject>> search(Pageable pagination);
    DetailsDataProject create(RegisterDataProject request);
    DetailsDataProject show(Long id);
    void destroy(Long id);
    DetailsDataProject update(Long id, UpdateDataProject request);
}

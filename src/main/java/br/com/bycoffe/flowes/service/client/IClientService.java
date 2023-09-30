package br.com.bycoffe.flowes.service.client;

import br.com.bycoffe.flowes.models.client.dto.DetailsDataClient;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IClientService {
    PagedModel<EntityModel<ListingDataClient>> search(Pageable pagination);
    DetailsDataClient create(RegisterUpdateDataClient request);
    DetailsDataClient show(Long id);
    void destroy(Long id);
    DetailsDataClient update(RegisterUpdateDataClient request, Long id);
}

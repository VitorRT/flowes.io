package br.com.bycoffe.flowes.service.task;

import br.com.bycoffe.flowes.models.task.dto.DetailsDataTask;
import br.com.bycoffe.flowes.models.task.dto.ListingDataTask;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.task.dto.UpdateDataTask;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface ITaskService {
    PagedModel<EntityModel<ListingDataTask>> search(Pageable pagination);
    DetailsDataTask create(RegisterDataTask request);
    DetailsDataTask show(Long id);
    void destroy(Long id);
    DetailsDataTask update(Long id, UpdateDataTask request);
}

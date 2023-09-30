package br.com.bycoffe.flowes.controller.client.impl;

import br.com.bycoffe.flowes.controller.client.IClientController;
import br.com.bycoffe.flowes.models.client.dto.DetailsDataClient;
import br.com.bycoffe.flowes.models.client.dto.ListingDataClient;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import br.com.bycoffe.flowes.service.client.IClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@Tag(name = "Client 🙋🏾‍♂️")
public class ClientControllerImpl implements IClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ListingDataClient>>> search(Pageable pagination) {
        return ResponseEntity.ok(clientService.search(pagination));
    }

    @PostMapping
    public ResponseEntity<DetailsDataClient> create(RegisterUpdateDataClient request, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsDataClient> show(Long id) {
        return ResponseEntity.ok(clientService.show(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(Long id) {
        clientService.destroy(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailsDataClient> update(Long id, RegisterUpdateDataClient request) {
        return ResponseEntity.ok(clientService.update(request, id));
    }
}

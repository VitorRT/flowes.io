package br.com.bycoffe.flowes.controller.workspace.impl;

import br.com.bycoffe.flowes.controller.workspace.IWorkspaceController;
import br.com.bycoffe.flowes.models.workspace.dto.DetailsDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.models.workspace.dto.UpdateDataWorkspace;
import br.com.bycoffe.flowes.service.workspace.IWorkspaceService;
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
@RequestMapping("/api/v1/workspace")
@Tag(name = "Workspace 💻")
public class WorkspaceControllerImpl implements IWorkspaceController {
    @Autowired
    private IWorkspaceService workspaceService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ListingDataWorkspace>>> search(Pageable pagination) {
        return ResponseEntity.ok(workspaceService.search(pagination));
    }

    @PostMapping
    public ResponseEntity<DetailsDataWorkspace> create(RegisterDataWorkspace request, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workspaceService.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsDataWorkspace> show(Long id) {
        return ResponseEntity.ok(workspaceService.show(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(Long id) {
        workspaceService.destroy(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailsDataWorkspace> update(Long id, UpdateDataWorkspace request) {
        return ResponseEntity.ok(workspaceService.update(id, request));
    }
}

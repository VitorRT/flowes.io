package br.com.bycoffe.flowes.controller.project.impl;

import br.com.bycoffe.flowes.controller.project.IProjectController;
import br.com.bycoffe.flowes.models.project.dto.DetailsDataProject;
import br.com.bycoffe.flowes.models.project.dto.ListingDataProject;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.project.dto.UpdateDataProject;
import br.com.bycoffe.flowes.service.project.IProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
@Tag(name = "Project 📅")
public class ProjectControllerImpl implements IProjectController {
    @Autowired
    private IProjectService projectService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ListingDataProject>>> search(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(projectService.search(pagination));
    }

    @PostMapping
    public ResponseEntity<DetailsDataProject> create(RegisterDataProject request, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsDataProject> show(Long id) {
        return ResponseEntity.ok(projectService.show(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(Long id) {
        projectService.destroy(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailsDataProject> update(Long id, UpdateDataProject request) {
        return ResponseEntity.ok(projectService.update(id, request));
    }
}

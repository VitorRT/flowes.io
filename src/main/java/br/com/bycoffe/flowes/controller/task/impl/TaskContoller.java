package br.com.bycoffe.flowes.controller.task.impl;

import br.com.bycoffe.flowes.controller.task.ITaskController;
import br.com.bycoffe.flowes.models.task.dto.DetailsDataTask;
import br.com.bycoffe.flowes.models.task.dto.ListingDataTask;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.task.dto.UpdateDataTask;
import br.com.bycoffe.flowes.service.task.ITaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "Task ✅")
public class TaskContoller implements ITaskController {
    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ListingDataTask>>> search(Pageable pagination) {
        return ResponseEntity.ok(taskService.search(pagination));
    }

    @PostMapping
    public ResponseEntity<DetailsDataTask> create(RegisterDataTask request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsDataTask> show(Long id) {
        return ResponseEntity.ok(taskService.show(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DetailsDataTask> destroy(Long id) {
        taskService.destroy(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailsDataTask> update(Long id, UpdateDataTask request) {
        return ResponseEntity.ok(taskService.update(id, request));
    }
}

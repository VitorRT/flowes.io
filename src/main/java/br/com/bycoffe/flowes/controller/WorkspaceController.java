package br.com.bycoffe.flowes.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.models.workspace.dto.ListingDataWorkspace;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/workspace")
public class WorkspaceController {
    
    Logger log = LoggerFactory.getLogger(WorkspaceController.class);
    
    @Autowired
    WorkspaceRepository repository;


    private Workspace getWorkspace(Long id) {
        return repository.findById(id).orElseThrow(() -> { 
            return new RestNotFoundException(
                "Nenhuma workspace com o id [ " + 
                id + 
                " ] foi encontrada."
                );
        });
    }


    @GetMapping
    public ResponseEntity<Page<ListingDataWorkspace>> returnClient(Pageable pagination) {
        log.info("[ Search ] Buscando Workspaces"); 
        Page<ListingDataWorkspace> pages = repository.findAllByCompleteTrue(pagination).map(ListingDataWorkspace::new);
        return ResponseEntity.ok(pages);
    }


    @PostMapping
    public ResponseEntity<Workspace> create(
        @RequestBody @Valid Workspace workspace,
        BindingResult result) {

        log.info("[ Create ] Cadastrando Workspace: " + workspace.getName()); 

        repository.save(workspace);

        return ResponseEntity.status(HttpStatus.CREATED).body(workspace);
    }

    @GetMapping("{id}")
    public ResponseEntity<Workspace> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Workspace: " + id);

        Workspace workspaceEncontrado = getWorkspace(id);

        return ResponseEntity.ok(workspaceEncontrado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Workspace> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Workspace: " + id);

        Workspace workspaceEncontrado = getWorkspace(id);

        repository.delete(workspaceEncontrado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Workspace> update(
        @PathVariable Long id, 
        @RequestBody Workspace workspace) {
        log.info("[ Update ] Atualizando Workspace: " + id);

        getWorkspace(id);

        workspace.setId(id);
        workspace.setUpdatedAt(LocalDateTime.now());
        repository.save(workspace);
        
        return ResponseEntity.ok(workspace);
    }
}

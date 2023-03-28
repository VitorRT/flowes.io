package br.com.bycoffe.flowes.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.Workspace;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;

@RestController
@RequestMapping("/api/v1/workspace")
public class WorkspaceController {
    
    Logger log = LoggerFactory.getLogger(WorkspaceController.class);
    
    @Autowired
    WorkspaceRepository repository;



    @GetMapping
    public List<Workspace> returnClient() {

        log.info("[ Search ] Buscando Workspaces"); 

        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Workspace> create(@RequestBody Workspace workspace) {

        log.info("[ Create ] Cadastrando Workspace: " + workspace.getName()); 

        repository.save(workspace);

        return ResponseEntity.status(HttpStatus.CREATED).body(workspace);
    }

    @GetMapping("{id}")
    public ResponseEntity<Workspace> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Workspace: " + id);

        Optional<Workspace> workspaceEncontrado = repository.findById(id);

        if(workspaceEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(workspaceEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Workspace> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Workspace: " + id);

        Optional<Workspace> workspaceEncontrado = repository.findById(id);

        if(workspaceEncontrado.isEmpty()) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repository.delete(workspaceEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Workspace> update(@PathVariable Long id, @RequestBody Workspace workspace) {
        log.info("[ Update ] Atualizando Cliente: " + id);

        Optional<Workspace> workspaceEncontrado = repository.findById(id);

        if(workspaceEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
       // BeanUtils.copyProperties(clientEncontrado, clienteAtualizado, "id");

        workspace.setId(id);
        workspace.setUpdatedAt(LocalDateTime.now());
        repository.save(workspace);
        
        return ResponseEntity.ok(workspace);
    }
}

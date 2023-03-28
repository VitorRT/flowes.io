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


import br.com.bycoffe.flowes.models.Project;
import br.com.bycoffe.flowes.repository.ProjectRepository;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    
    Logger log = LoggerFactory.getLogger(ProjectController.class);
    
    @Autowired
    ProjectRepository repository;



    @GetMapping
    public List<Project> returnClient() {

        log.info("[ Search ] Buscando Projects"); 

        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {

        log.info("[ Create ] Cadastrando Project: " + project.getName()); 

        repository.save(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Project: " + id);

        Optional<Project> projectEncontrado = repository.findById(id);

        if(projectEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(projectEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Project> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Project: " + id);

        Optional<Project> projectEncontrado = repository.findById(id);

        if(projectEncontrado.isEmpty()) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repository.delete(projectEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project) {
        log.info("[ Update ] Atualizando Cliente: " + id);

        Optional<Project> workspaceEncontrado = repository.findById(id);

        if(workspaceEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
       // BeanUtils.copyProperties(clientEncontrado, clienteAtualizado, "id");

        project.setId(id);
        project.setUpdatedAt(LocalDateTime.now());
        repository.save(project);
        
        return ResponseEntity.ok(project);
    }

}

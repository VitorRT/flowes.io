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

import br.com.bycoffe.flowes.models.Task;
import br.com.bycoffe.flowes.repository.TaskRepository;

@RestController
@RequestMapping("/api/v1/task")
public class TaskContoller {
    
    Logger log = LoggerFactory.getLogger(TaskContoller.class);
    
    @Autowired
    TaskRepository repository;


    @GetMapping
    public List<Task> returnClient() {

        log.info("[ Search ] Buscando Tasks"); 

        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {

        log.info("[ Create ] Cadastrando Task: " + task.getName()); 

        repository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> show(@PathVariable Long id) {

        log.info("[ Show ] Buscando Task: " + id);

        Optional<Task> taskEncontrado = repository.findById(id);

        if(taskEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(taskEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> destroy(@PathVariable Long id) {

        log.info("[ Destroy ] Apagando Task: " + id);

        Optional<Task> taskEncontrado = repository.findById(id);

        if(taskEncontrado.isEmpty()) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repository.delete(taskEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        log.info("[ Update ] Atualizando Task: " + id);

        Optional<Task> taskEncontrado = repository.findById(id);

        if(taskEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
       // BeanUtils.copyProperties(clientEncontrado, clienteAtualizado, "id");

        task.setId(id);
        task.setUpdatedAt(LocalDateTime.now());
        repository.save(task);
        
        return ResponseEntity.ok(task);
    }
}

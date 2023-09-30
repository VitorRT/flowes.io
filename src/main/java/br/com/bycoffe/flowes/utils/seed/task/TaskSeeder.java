package br.com.bycoffe.flowes.utils.seed.task;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.repository.TaskRepository;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public abstract class TaskSeeder {
    public static void seed(TaskRepository taskRepository) {
        /** Criando tasks para projects */
        log.info("[ Seed ] - Semeando tasks...");
        taskRepository.saveAll(List.of(
                new Task(new RegisterDataTask(new Project(1L), "Fazer trabalho de matemática", "Tarefa", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
                new Task(new RegisterDataTask(new Project(1L), "Estudar para a prova de história", "Estudo", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
                new Task(new RegisterDataTask(new Project(1L), "Estudar Ciências", "Estudo", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
                new Task(new RegisterDataTask(new Project(1L), "Fazer lição de matemática - Pag 324, Ex 32,33,34,35 e 36", "Tarefa", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA))
                ));
        log.info("[ Seed ] - Semente de tasks plantada!");
        System.out.println("\n");
        /** FIM */

    }
}

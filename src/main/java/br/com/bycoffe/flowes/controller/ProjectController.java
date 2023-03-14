package br.com.bycoffe.flowes.controller;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.deadline.Deadline;
import br.com.bycoffe.flowes.deadline.DeadlineEnd;
import br.com.bycoffe.flowes.deadline.DeadlineStart;
import br.com.bycoffe.flowes.models.Project;

@RestController
public class ProjectController {
    
    @GetMapping("/api/v1/project")
    public Project returnProject() {
        DeadlineStart start = new DeadlineStart(LocalDate.now(), Calendar.HOUR);
        DeadlineEnd end = new DeadlineEnd(LocalDate.now(), Calendar.HOUR);
        Deadline deadline = new Deadline(start, end);

        return new Project(1l, "NewTale Back-End Mobile 📱", deadline , "#AEEBB4", "Tarefas para o desenvolvimento back-end da rede social NewTale");
    }

}

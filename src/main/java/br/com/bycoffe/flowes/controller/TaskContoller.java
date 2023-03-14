package br.com.bycoffe.flowes.controller;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.deadline.DeadlineTask;
import br.com.bycoffe.flowes.models.Task;

@RestController
public class TaskContoller {
    
    @GetMapping("/api/v1/task")
    public Task returnTask() {

        DeadlineTask deadlineTask = new DeadlineTask(Calendar.HOUR, Calendar.HOUR_OF_DAY);

        return new Task(1l,"Create Spring 3.0.x Project", "Back-End 💻", "", deadlineTask);
    }
}

package br.com.bycoffe.flowes.utils.deadline;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeadlineTask {
    @Column(name = "start_task", nullable = false)
    private LocalDateTime startTask;

    @Column(name = "end_task", nullable = false)
    private LocalDateTime endTask;

    public DeadlineTask() { }


    public DeadlineTask(LocalDateTime startTask, LocalDateTime endTask) {
        this.startTask = startTask;
        this.endTask = endTask;
    }


    public LocalDateTime getStartTask() {
        return startTask;
    }
    public void setStartTask(LocalDateTime startTask) {
        this.startTask = startTask;
    }
    public LocalDateTime getEndTask() {
        return endTask;
    }
    public void setEndTask(LocalDateTime endTask) {
        this.endTask = endTask;
    }

    
}

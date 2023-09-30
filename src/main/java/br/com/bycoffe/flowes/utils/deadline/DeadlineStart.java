package br.com.bycoffe.flowes.utils.deadline;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class DeadlineStart {

    @NotNull
    @FutureOrPresent
    private LocalDateTime start_date;


    protected DeadlineStart() { }

    public DeadlineStart(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }
}

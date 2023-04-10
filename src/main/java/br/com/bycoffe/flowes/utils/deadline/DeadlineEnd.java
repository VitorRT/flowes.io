package br.com.bycoffe.flowes.utils.deadline;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class DeadlineEnd {

    @NotNull
    @FutureOrPresent
    private LocalDateTime end_date;

    protected DeadlineEnd() { }


    public DeadlineEnd(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }


    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }  

}

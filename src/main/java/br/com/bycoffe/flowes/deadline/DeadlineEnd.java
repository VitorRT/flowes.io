package br.com.bycoffe.flowes.deadline;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeadlineEnd {
    @Column(nullable = false)
    private LocalDate end_date;
    @Column(nullable = false)
    private int end_hours;

    protected DeadlineEnd() { }


    public DeadlineEnd(LocalDate end_date, int end_hours) {
        this.end_date = end_date;
        this.end_hours = end_hours;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }


    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }


    public int getEnd_hours() {
        return end_hours;
    }


    public void setEnd_hours(int end_hours) {
        this.end_hours = end_hours;
    }
    
}

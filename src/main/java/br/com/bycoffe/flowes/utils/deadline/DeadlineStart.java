package br.com.bycoffe.flowes.utils.deadline;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeadlineStart {
    @Column(nullable = false)
    private LocalDate start_date;
    @Column(nullable = false)
    private int start_hours;


    protected DeadlineStart() { }

    public DeadlineStart(LocalDate start_date, int start_hours) {
        this.start_date = start_date;
        this.start_hours = start_hours;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public int getStart_hours() {
        return start_hours;
    }

    public void setStart_hours(int start_hours) {
        this.start_hours = start_hours;
    }
}

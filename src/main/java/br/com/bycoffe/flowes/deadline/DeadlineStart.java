package br.com.bycoffe.flowes.deadline;

import java.time.LocalDate;

public class DeadlineStart {
    private LocalDate start_date;
    private int start_hours;

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

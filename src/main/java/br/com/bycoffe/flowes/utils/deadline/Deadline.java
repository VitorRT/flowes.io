package br.com.bycoffe.flowes.utils.deadline;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Deadline {
    @Embedded
    private DeadlineStart start;
    @Embedded
    private DeadlineEnd end;

    protected Deadline() { }


    public Deadline(DeadlineStart start, DeadlineEnd end) {
        this.start = start;
        this.end = end;
    }

    public DeadlineStart getStart() {
        return start;
    }

    public void setStart(DeadlineStart start) {
        this.start = start;
    }

    public DeadlineEnd getEnd() {
        return end;
    }

    public void setEnd(DeadlineEnd end) {
        this.end = end;
    }
    
}

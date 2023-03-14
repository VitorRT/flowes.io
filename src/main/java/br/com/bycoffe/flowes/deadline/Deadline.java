package br.com.bycoffe.flowes.deadline;

public class Deadline {
    private DeadlineStart start;
    private DeadlineEnd end;


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

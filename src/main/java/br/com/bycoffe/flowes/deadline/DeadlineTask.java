package br.com.bycoffe.flowes.deadline;

public class DeadlineTask {
    private int start_hour;
    private int end_hour;


    public DeadlineTask(int start_hour, int end_hour) {
        this.start_hour = start_hour;
        this.end_hour = end_hour;
    }


    public int getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(int start_hour) {
        this.start_hour = start_hour;
    }

    public int getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(int end_hour) {
        this.end_hour = end_hour;
    }
}

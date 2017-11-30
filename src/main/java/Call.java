public class Call {
    private Boolean answered;
    private Integer minTime;
    private Integer maxTime;
    private Attendant attendant;

    public Call(int minTimeInSeconds,int maxTimeInSeconds) {
        this.minTime = minTimeInSeconds;
        this.maxTime = maxTimeInSeconds;
        this.answered = false;
    }

    public Boolean isAswered() {
        return this.answered;
    }

    public void answer() {
        this.answered = true;
    }

    public Integer getMinTime() {
        return this.minTime;
    }

    public Integer getMaxTime() {
        return this.maxTime;
    }

    public void end() {
        this.attendant.free();
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }
}

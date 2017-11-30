public class Call {
    private boolean answered;
    private Integer minTime;
    private Integer maxTime;

    public Call(int minTimeInSeconds,int maxTimeInSeconds) {
        this.minTime = minTimeInSeconds;
        this.maxTime = maxTimeInSeconds;
        this.answered = false;
    }

    public boolean isAswered() {
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
}

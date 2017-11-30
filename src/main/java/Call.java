public class Call {
    private boolean answered;
    private Integer minDuration;

    public Call(int minDurationInSeconds) {
        this.minDuration = minDurationInSeconds;
        this.answered = false;
    }

    public boolean isAswered() {
        return this.answered;
    }

    public void answer() {
        this.answered = true;
    }

    public Integer getMinTime() {
        return this.minDuration;
    }
}

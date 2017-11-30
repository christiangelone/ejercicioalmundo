public class Call {
    private boolean answered;

    public Call(int durationInSeconds) {
        this.answered = false;
    }

    public boolean isAswered() {
        return this.answered;
    }

    public void answer() {
        this.answered = true;
    }
}

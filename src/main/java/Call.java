import java.util.concurrent.ThreadLocalRandom;

public class Call {

    private final Integer id;
    private Boolean answered;
    private Integer minTime;
    private Integer maxTime;
    private Attendant attendant;

    public Call(Integer id,Integer minTimeInSeconds,Integer maxTimeInSeconds) {
        this.id = id;
        this.minTime = minTimeInSeconds;
        this.maxTime = maxTimeInSeconds;
        this.answered = false;
    }

    public Boolean isAnswered() {
        return this.answered;
    }

    public synchronized void answer() {
        new Thread(() -> {
           int randomSecs = ThreadLocalRandom.current().nextInt(minTime, maxTime + 1);
            //System.out.println("RandomSec " + randomSecs);
            try {
                Thread.sleep(randomSecs * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            end();
        }).start();
        this.answered = true;
    }

    public Integer getMinTime() {
        return this.minTime;
    }

    public Integer getMaxTime() {
        return this.maxTime;
    }

    public synchronized void end() {
        if(this.attendant.isBusy())
            this.attendant.free();
    }

    public Integer getId() {
        return id;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }
}

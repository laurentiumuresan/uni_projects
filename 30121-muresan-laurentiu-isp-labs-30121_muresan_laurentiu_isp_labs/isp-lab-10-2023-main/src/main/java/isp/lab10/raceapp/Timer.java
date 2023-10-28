package isp.lab10.raceapp;

public class Timer extends Thread{
    private String raceTime;
    private long duration;
    private volatile boolean isRunning = true;

    public void run() {
        long startTime = System.currentTimeMillis();
        while (isRunning) {
            try {
                Thread.sleep(10);
                duration+=10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            duration = System.currentTimeMillis() - startTime;
        }
       raceTime= "Race time: " + duration + "ms";
    }

    public void stopTimer() {
        isRunning = false;
    }

    public long getDuration() {
        return duration;
    }

    public String getRaceTime() {
        return raceTime;
    }
}

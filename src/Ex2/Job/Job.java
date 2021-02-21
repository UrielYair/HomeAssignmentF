package Ex2.Job;

import Ex2.OS.OS;


public class Job {
    public void sleep(long timeInMillis) {
        if (timeInMillis <= 0) throw new IllegalArgumentException("time in milliseconds must be positive.");
        OS.putJobToSleep(timeInMillis,this);
    }
}

package Ex2.OS;

import Ex2.Consumer.Consumer;
import Ex2.Producer.Producer;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class OS {

    private BlockingQueue<String> sleepingJobs;
    Thread consumer;
    Set<String> runningJobs;

    public OS(int capacity) {
        ConcurrentHashMap<String, Integer> jobsMap = new ConcurrentHashMap<>();
        this.runningJobs = ConcurrentHashMap.newKeySet(jobsMap.size());

        this.sleepingJobs = new ArrayBlockingQueue<>(capacity);
        this.consumer = new Thread(new Consumer(sleepingJobs, runningJobs));
        consumer.start();
    }

    public BlockingQueue<String> getSleepingJobs() {
        return sleepingJobs;
    }

    public void sleep(String jobId, long timeInMillis){
        runningJobs.remove(jobId);
        Thread producer = new Thread(new Producer(sleepingJobs, timeInMillis, jobId));
        producer.start();
    }

    public void runJob(String jobId){
        runningJobs.add(jobId);
    }

    public Set<String> getRunningJobs() {
        return runningJobs;
    }
}

package Ex2.Consumer;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<String> queue;
    Set<String> runningJobs;

    public Consumer(BlockingQueue<String> queue, Set<String> runningJobs) {
        this.queue = queue;
        this.runningJobs = runningJobs;
    }

    public void awake() {
            try {
                String job = queue.take();
                System.out.println(job + " is running.");
                runningJobs.add(job);
                Thread.sleep(100); // for output clarity
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void run() {
        while (true){
            awake();
        }
    }
}
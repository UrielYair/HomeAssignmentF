package Ex2.Producer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<String> queue;
    private Long millis;
    private String jobId;

    public Producer(BlockingQueue<String> queue, Long millis, String jobId) {
        this.queue = queue;
        this.millis = millis;
        this.jobId = jobId;
    }

    @Override
    public void run() {
        try {
            queue.put(this.jobId);
            Thread.sleep(this.millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
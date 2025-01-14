import java.util.concurrent.BlockingQueue;

public class Master extends Thread {
    private final BlockingQueue<Runnable> workQueue;

    public Master(BlockingQueue<Runnable> queue) {
        this.workQueue = queue;
    }

    @Override
    public void run() {
        // Example: generating 1,000,000 tasks to be processed.
        for (int i = 0; i < 1_000_000; i++) {
            Runnable task = () -> {
                System.out.println("Task executed");
                // Task processing logic goes here
            };
            try {
                workQueue.put(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
    }
}
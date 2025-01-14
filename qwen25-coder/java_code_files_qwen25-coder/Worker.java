import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final BlockingQueue<Runnable> workQueue;

    public Worker(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Runnable task = workQueue.take(); // Blocks if no tasks are available
                task.run(); // Process the task
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
    }
}
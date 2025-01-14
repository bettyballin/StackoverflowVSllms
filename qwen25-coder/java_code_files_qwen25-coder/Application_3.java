import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application_3 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        int numberOfWorkers = Runtime.getRuntime().availableProcessors() * 2; // e.g., twice the number of cores

        // Create and start workers
        for (int i = 0; i < numberOfWorkers; i++) {
            Thread workerThread = new Thread(new Worker(workQueue));
            workerThread.start();
        }

        // Create and run the master
        Thread masterThread = new Master(workQueue);
        masterThread.start();

        try {
            masterThread.join(); // Wait for all tasks to be added

            // Add poison pills to terminate workers after queue is empty
            for (int i = 0; i < numberOfWorkers; i++) {
                workQueue.put(() -> {}); // Poison pill task
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Worker implements Runnable {
    private final BlockingQueue<Runnable> workQueue;

    public Worker(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Runnable task = workQueue.take();
                if (task == null) {
                    break; // Exit if poison pill received
                }
                task.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Master extends Thread {
    private final BlockingQueue<Runnable> workQueue;

    public Master(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        // Add tasks to the workQueue
        for (int i = 0; i < 10; i++) { // Example: create 10 tasks
            int taskId = i;
            workQueue.add(() -> {
                System.out.println("Executing task " + taskId);
            });
        }
    }
}
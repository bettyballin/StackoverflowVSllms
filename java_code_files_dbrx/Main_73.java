import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main(String[] args) {
        int N_WORKERS = 4;

        ExecutorService executor = Executors.newFixedThreadPool(4);  // create pool with fixed number of threads
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();   // A work queue for tasks to be executed by the workers
        // Create and start worker threads
        for (int i = 0; i < N_WORKERS; i++) {
            Worker w = new Worker(queue);
            executor.execute(w);                         // Submits a task to this Executor for execution
        }
        executor.shutdown();   // Stops accepting new tasks and closes it down after existing ones are completed.
    }
}

class Worker implements Runnable {
    private BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // Worker thread processing tasks from the queue
        while (true) {
            try {
                Runnable task = queue.take(); // take a task from the queue
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // Exit the loop if interrupted
            }
        }
    }
}
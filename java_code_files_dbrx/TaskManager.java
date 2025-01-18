// Simple example in Java via Callables and Future
import java.util.concurrent.*;

public class TaskManager {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<?> taskFuture;

    public void startTask() {
        taskFuture = executor.submit(() -> {
            try {
                // some long running process here, simulated with 5 sec sleep
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // handle interruption
                System.out.println("Task was interrupted.");
            }
        });
    }

    public void cancelTask() {
       if (!taskFuture.isDone()){
          taskFuture.cancel(true);
          System.out.println("Task was cancelled.");
       } else {
         System.out.println("Sorry, but the request has already been processed.");
       }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.startTask();
        try {
            Thread.sleep(2000); // Wait for 2 seconds before attempting to cancel
        } catch (InterruptedException e) {
            // handle interruption
        }
        tm.cancelTask();
        tm.executor.shutdown();
    }
}
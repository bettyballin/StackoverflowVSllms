import java.util.concurrent.*;
import java.util.*;

public class ThreadManager {
    private final ExecutorService executorService;
    private final Map<String, Future<?>> tasks;

    public ThreadManager(int corePoolSize) {
        this.executorService = Executors.newFixedThreadPool(corePoolSize);
        this.tasks = new ConcurrentHashMap<>();
    }

    public void submitTask(String taskId, Runnable task) {
        Future<?> future = executorService.submit(task);
        tasks.put(taskId, future);
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public boolean cancelTask(String taskId) {
        Future<?> future = tasks.get(taskId);
        if (future != null) {
            return future.cancel(true); // true to attempt to stop the task
        }
        return false;
    }

    public Set<Map.Entry<String, Future<?>>> getTasks() {
        return tasks.entrySet();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager threadManager = new ThreadManager(10);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadManager.submitTask("task" + i, () -> {
                try {
                    System.out.println("Executing task " + taskId);
                    TimeUnit.SECONDS.sleep(5); // simulate a long-running task
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " was interrupted");
                }
            });
        }

        Thread.sleep(3000); // let the tasks start

        // Cancel some tasks
        threadManager.cancelTask("task1");
        threadManager.cancelTask("task2");

        // Check task statuses after trying to cancel them
        for (Map.Entry<String, Future<?>> entry : threadManager.getTasks()) {
            System.out.println("Task ID: " + entry.getKey() + ", Is cancelled: " + entry.getValue().isCancelled());
        }

        threadManager.shutdown();
    }
}
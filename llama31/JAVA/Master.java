import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

class Task {
    private String taskId;
    private Object data;

    public Task(String taskId, Object data) {
        this.taskId = taskId;
        this.data = data;
    }

    public String getTaskId() {
        return taskId;
    }
}

class CompletedTask {
    private Object result;
    private String taskId;

    public CompletedTask(Object result) {
        this.result = result;
    }

    public String getTaskId() {
        return taskId;
    }
}

public class Master {
    private final BlockingQueue<CompletedTask> completedTasks = new LinkedBlockingQueue<>();
    private final AtomicInteger nextTaskIndex = new AtomicInteger(0);
    private final ConcurrentHashMap<String, Task> taskMap = new ConcurrentHashMap<>();
    private final int numTasks = 100;
    private Object data;

    public void scheduleTasks() {
        int startIndex = nextTaskIndex.getAndAdd(numTasks);
        int endIndex = startIndex + numTasks;
        // Create a task batch and schedule it
        for (int i = startIndex; i < endIndex; i++) {
            String taskId = "task-" + i;
            Task task = new Task(taskId, data);
            taskMap.put(taskId, task);
            // Schedule the task
        }
    }

    public void processCompletedTasks() {
        CompletedTask task = completedTasks.poll();
        if (task != null) {
            // Process the completed task
            taskMap.remove(task.getTaskId());
        }
    }
}

class Worker implements Runnable {
    private final Master master;
    private final String taskId;

    public Worker(Master master, String taskId) {
        this.master = master;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        // Perform the task
        CompletedTask task = new CompletedTask(null); // Replace null with actual result
        master.completedTasks.add(task);
    }
}

public class Main {
    public static void main(String[] args) {
        Master master = new Master();
        master.scheduleTasks();

        Worker worker = new Worker(master, "task-1");
        Thread thread = new Thread(worker);
        thread.start();
    }
}
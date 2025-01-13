import java.util.concurrent.ConcurrentHashMap;

// Define a Task class
class Task {
    private String taskId;
    private Object data;

    public Task(String taskId, Object data) {
        this.taskId = taskId;
        this.data = data;
    }
}

public class Main_210 {
    public static void main(String[] args) {
        // Master-side
        ConcurrentHashMap<String, Task> taskMap = new ConcurrentHashMap<>();

        // Worker-side
        String taskId = "task-123";
        Object data = new Object(); // Define some data
        Task task = new Task(taskId, data);
        if (!taskMap.containsKey(taskId)) {
            taskMap.put(taskId, task);
            // Schedule the task
            System.out.println("Task scheduled: " + taskId);
        }
    }
}
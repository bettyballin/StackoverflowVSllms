import java.lang.String;
import java.util.PriorityQueue;
import java.util.Comparator;

class Task {
    int priority;
    String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Comparator to create a min-heap based on priority
        Comparator<Task> comparator = Comparator.comparingInt(task -> task.priority);

        // Creating a Priority Queue with the custom comparator
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(comparator);

        // Adding tasks with different priorities
        priorityQueue.add(new Task(1, "Low priority task"));
        priorityQueue.add(new Task(0, "High priority task"));
        priorityQueue.add(new Task(2, "Medium priority task"));

        // Processing tasks by priority (highest first)
        while (!priorityQueue.isEmpty()) {
            Task nextTask = priorityQueue.poll();
            System.out.println("Processing: " + nextTask.description);
        }
    }
}
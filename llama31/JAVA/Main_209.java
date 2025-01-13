import java.util.concurrent.atomic.AtomicInteger;

public class Main_209 {
    public static void main(String[] args) {
        // Master-side
        AtomicInteger nextTaskIndex = new AtomicInteger(0);
        int numTasks = 100;

        // Schedule tasks
        int startIndex = nextTaskIndex.getAndAdd(numTasks);
        int endIndex = startIndex + numTasks;
        // Create a task batch and schedule it
        System.out.println("Start Index: " + startIndex);
        System.out.println("End Index: " + endIndex);
    }
}
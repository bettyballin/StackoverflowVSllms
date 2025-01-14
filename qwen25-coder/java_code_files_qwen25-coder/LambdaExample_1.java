import java.util.ArrayList;
import java.util.List;

public class LambdaExample_1 {
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int tmp = i; // Copy the loop variable to a local final
            tasks.add(() -> System.out.println("Task " + tmp));
        }
        
        // Execute the tasks
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
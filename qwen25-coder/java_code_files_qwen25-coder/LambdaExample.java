import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int index = i;
            tasks.add(() -> System.out.println("Task " + index));
        }
        
        // Execute the tasks
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
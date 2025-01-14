import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Task {
    private int position;

    public Task(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

public class Main {
    // Inside a method where tasks is your List<Task>
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        // Add some tasks to the list
        tasks.add(new Task(5));
        tasks.add(new Task(3));
        tasks.add(new Task(1));

        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getPosition(), t2.getPosition());
            }
        });

        // Print the sorted tasks
        for (Task task : tasks) {
            System.out.println("Task position: " + task.getPosition());
        }
    }
}
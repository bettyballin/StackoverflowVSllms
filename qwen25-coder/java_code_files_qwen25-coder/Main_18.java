import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(3));
        tasks.add(new Task(1));
        tasks.add(new Task(2));

        // Inside a method where tasks is your List<Task>
        tasks = tasks.stream()
                     .sorted(Comparator.comparingInt(Task::getPosition))
                     .collect(Collectors.toList());

        // Output the sorted tasks to verify the result
        for (Task task : tasks) {
            System.out.println("Task Position: " + task.getPosition());
        }
    }
}

class Task {
    private int position;

    public Task(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
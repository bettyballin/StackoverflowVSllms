import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Define a Task class
class Task {
    private int position;

    public Task(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

public class TaskSorter_3_3 {
    public static void main(String[] args) {
        // Create a list of Task objects
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(3));
        tasks.add(new Task(1));
        tasks.add(new Task(2));

        // Sort the tasks
        sortTasks(tasks);

        // Print the sorted tasks
        for (Task task : tasks) {
            System.out.println(task.getPosition());
        }
    }

    public static void sortTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getPosition));
    }
}
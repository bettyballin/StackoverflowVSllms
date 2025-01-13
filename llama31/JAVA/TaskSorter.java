import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Task {
    public int getPosition() {
        return 0; // default implementation
    }
}

public class TaskSorter {
    List<Task> sortedTasks(List<Task> tasks) {
        return tasks.stream()
                .sorted(Comparator.comparingInt(Task::getPosition))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TaskSorter taskSorter = new TaskSorter();
        // example usage:
        List<Task> tasks = List.of(new Task(), new Task());
        List<Task> sortedTasks = taskSorter.sortedTasks(tasks);
    }
}
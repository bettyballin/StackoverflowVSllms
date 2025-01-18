import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TaskSorter {
    List<Task> sortedTasks = tasks.stream()
                                  .sorted(Comparator.comparingInt(task -> task.getPosition()))
                                  .collect(Collectors.toList());
    public static void main(String[] args) {
    }
}
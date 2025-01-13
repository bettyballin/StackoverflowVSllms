import java.util.Collections;
import java.util.Comparator;
import java.lang.String;

class Task {
    private int position;

    public int getPosition() {
        return position;
    }
}

public class TaskSorter_1_1 {
    public static void main(String[] args) {
        // Assume tasks is a list of Task objects
        Task[] tasks = new Task[0]; // Initialize with an empty array
        Collections.sort(java.util.Arrays.asList(tasks), Comparator.comparingInt(Task::getPosition));
    }
}
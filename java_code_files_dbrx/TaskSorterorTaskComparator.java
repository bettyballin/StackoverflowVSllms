import java.lang.String;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class TaskSorterorTaskComparator {

    static List<Task> tasks = new ArrayList<>();

    static {
        Collections.sort(tasks, Comparator.comparingInt(task -> task.getPosition()));
    }

    public static void main(String[] args) {
    }
}

class Task {
    public int getPosition() {
        return 0;
    }
}
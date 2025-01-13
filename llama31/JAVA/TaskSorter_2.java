import java.util.Collections;
import java.util.Comparator;

public class TaskSorter_2_2 {
    public static void main(String[] args) {
        // Define the tasks list and the Task class for the code to compile
        // Assuming Task is a custom class with getPosition method
        // For demonstration purposes, I'll create a simple Task class
        class Task {
            private int position;

            public int getPosition() {
                return position;
            }

            public Task(int position) {
                this.position = position;
            }
        }

        // Create a list of tasks
        java.util.List<Task> tasks = new java.util.ArrayList<>();
        tasks.add(new Task(2));
        tasks.add(new Task(1));
        tasks.add(null); // For nullsFirst demonstration

        // The original line of code
        Collections.sort(tasks, Comparator.nullsFirst(Comparator.comparingInt(Task::getPosition)));

        // Print the sorted tasks to verify
        for (Task task : tasks) {
            if (task != null) {
                System.out.println(task.getPosition());
            } else {
                System.out.println("null");
            }
        }
    }
}
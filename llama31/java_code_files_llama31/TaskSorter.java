/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSorter {
    List<Task> sortedTasks(List<Task> list) {
        return list.stream().sorted(Comparator.comparingInt(Task::getPosition)).collect(Collectors.toList());
    }

    public static void main(String[] stringArray) {
        TaskSorter taskSorter = new TaskSorter();
        List<Task> list = List.of(new Task(), new Task());
        List<Task> list2 = taskSorter.sortedTasks(list);
    }
}

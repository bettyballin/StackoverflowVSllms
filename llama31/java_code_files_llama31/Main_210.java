/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;

public class Main_210 {
    public static void main(String[] stringArray) {
        ConcurrentHashMap<String, Task> concurrentHashMap = new ConcurrentHashMap<String, Task>();
        String string = "task-123";
        Object object = new Object();
        Task task = new Task(string, object);
        if (!concurrentHashMap.containsKey(string)) {
            concurrentHashMap.put(string, task);
            System.out.println("Task scheduled: " + string);
        }
    }
}

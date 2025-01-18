import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyClass_33 {
    private static ConcurrentHashMap<String, ArrayList<String>> synchronizedMap = new ConcurrentHashMap<>();

    public void doWork(String key) {
        List<String> originalValues = synchronizedMap.getOrDefault(key, null);
        if (originalValues != null) {
            List<String> values = new CopyOnWriteArrayList<>(originalValues);
            // do something with `values` or the synchronized list from map,
            // now you can safely remove elements while leaving the original unchanged for other threads to see and work on.
        }
    }

    public static void addToMap(String key, String value) {
        synchronizedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public static void main(String[] args) {
    }
}
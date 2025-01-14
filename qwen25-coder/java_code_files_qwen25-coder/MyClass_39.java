import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class MyClass_39 {
    private static final Map<String, List<String>> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

    public void doWork(String key) {
        // Since remove itself is atomic, we only need to synchronize on the entire block
        synchronized (synchronizedMap) {
            List<String> values;
            while ((values = synchronizedMap.remove(key)) != null) {
                // Do something with values
                for (String value : values) {
                    System.out.println(value);  // Example operation
                }
            }
        }
    }

    public static void addToMap(String key, String value) {
        synchronized (synchronizedMap) {
            if (synchronizedMap.containsKey(key)) {
                synchronizedMap.get(key).add(value);
            } else {
                List<String> valuesList = new ArrayList<>();
                valuesList.add(value);
                synchronizedMap.put(key, valuesList);
            }
        }
    }

    public static void main(String[] args) {
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main_150_150 {
    public static void main(String[] args) {
        // Example map
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // Convert map values to list
        List<String> list = new ArrayList<>(map.values());

        // Print list
        System.out.println(list);
    }
}
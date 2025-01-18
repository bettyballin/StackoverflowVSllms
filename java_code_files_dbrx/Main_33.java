import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Main_33 {
    public static void main(String[] args) {
        Map<String, String> myHashMap = new HashMap<>();
        // Add some elements to hashmap
        myHashMap.put("c", "first value");
        myHashMap.put("a", "second value");
        myHashMap.put("b", "third value");

        // Convert HashMap into TreeMap
        Map<String, String> sortedMap = new TreeMap<>(myHashMap);

        for(String key : sortedMap.keySet()) {
            System.out.println(key + ":" + sortedMap.get(key));
        }
    }
}
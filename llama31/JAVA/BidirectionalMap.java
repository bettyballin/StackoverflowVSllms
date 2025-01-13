import java.util.Map;
import java.util.HashMap;

public class BidirectionalMap {
    Map<String, Integer> keyToValue = new HashMap<>();
    Map<Integer, String> valueToKey = new HashMap<>();

    public BidirectionalMap() {
        // Initialize the maps
        keyToValue.put("one", 1);
        keyToValue.put("two", 2);
        valueToKey.put(1, "one");
        valueToKey.put(2, "two");
    }

    public static void main(String[] args) {
        BidirectionalMap map = new BidirectionalMap();
        
        // Get value by key
        Integer value = map.keyToValue.get("one");
        System.out.println("Value for key 'one': " + value);

        // Get key by value
        String key = map.valueToKey.get(2);
        System.out.println("Key for value 2: " + key);
    }
}
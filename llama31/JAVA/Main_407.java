import java.util.HashMap;

public class Main_407 {
    public static void main(String[] args) {
        // assume 'map' is your HashMap object
        HashMap<String, String> map = new HashMap<>();

        // assume 'keys' is your set of keys
        String[] keys = {"key1", "key2", "key3"}; // example keys

        // populate the map
        map.put("key1", "value1");
        map.put("key2", "value2");

        for (String key : keys) {
            if (map.containsKey(key)) {
                // key is present in the hashmap, perform task
                System.out.println("Key " + key + " is present in the map.");
                // perform task here
            } else {
                // key is not present in the hashmap, perform alternative task
                System.out.println("Key " + key + " is not present in the map.");
                // perform alternative task here
            }
        }
    }
}
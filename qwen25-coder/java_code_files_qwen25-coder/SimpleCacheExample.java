import java.util.HashMap;
import java.util.Map;

public class SimpleCacheExample {
    private final Map<String, String> cache = new HashMap<>();

    public String getData(String key) {
        // Check if data is already in cache
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // Simulate database call
            String dataFromDatabase = fetchDataFromDatabase(key);
            cache.put(key, dataFromDatabase);  // Store in cache for future requests
            return dataFromDatabase;
        }
    }

    private String fetchDataFromDatabase(String key) {
        // This method would typically interact with a real database to fetch the data.
        // For this example, I'll just simulate it by returning a dummy value.
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        return "Data for " + key;
    }

    public static void main(String[] args) {
        SimpleCacheExample example = new SimpleCacheExample();
        System.out.println(example.getData("key1"));  // This should take around 100ms due to simulated database call.
        System.out.println(example.getData("key1"));  // This will be almost instantaneous, served from cache.
    }
}
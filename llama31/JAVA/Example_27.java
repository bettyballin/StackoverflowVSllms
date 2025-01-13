import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

public class Example_27_27 {
    public static void main(String[] args) {
        // Start Ignite node
        Ignite ignite = Ignition.start();

        // Get cache instance
        IgniteCache<String, String> cache = ignite.getOrCreateCache("myCache");

        // Store data in cache
        cache.put("key", "value");

        // Retrieve data from cache
        String value = cache.get("key");

        // Close the Ignite node to prevent resource leaks
        ignite.close();
    }
}
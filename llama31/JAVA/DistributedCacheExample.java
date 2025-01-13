import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.CacheConfiguration;

public class DistributedCacheExample {
    public static void main(String[] args) {
        // Create a GridGain configuration
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Create a cache configuration
        CacheConfiguration<String, String> cacheCfg = new CacheConfiguration<>("myCache");

        // Start a GridGain node
        Ignite ignite = Ignition.start(cfg);

        // Get the cache instance
        IgniteCache<String, String> cache = ignite.getOrCreateCache(cacheCfg);

        // Put a value into the cache
        cache.put("key", "value");

        // Get the value from the cache
        String value = cache.get("key");

        // Print the value
        System.out.println(value);

        // Stop the GridGain node
        ignite.close();
    }
}
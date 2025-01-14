import java.lang.String;
// Example of simple cache usage in Java (JCS, as AppFabric is typically used in .NET)
import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

public class CacheExample {
    public static void main(String[] args) throws Exception {
        // Get a cache instance
        CacheAccess<String, String> cache = JCS.getInstance("myCacheRegion");

        // Add an item to the cache
        cache.put("key", "value");

        // Retrieve an item from cache
        String value = cache.get("key");
        System.out.println(value);
    }
}

// Note: AppFabric Caching has its own configuration and API in .NET environment.
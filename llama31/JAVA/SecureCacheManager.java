import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheConfiguration;
import net.sf.ehcache.CacheManager;

public class SecureCacheManager {
    public static void main(String[] args) {
        // Create a cache manager with encryption enabled
        CacheManager cacheManager = CacheManager.newInstance();
        cacheManager.setEncryptionEnabled(true);

        // Create a cache with a secure configuration
        CacheConfiguration<String, String> config = new CacheConfiguration<>("myCache", String.class, String.class);
        config.setEncryptionAlgorithm("AES");
        config.setEncryptionKey("my_secret_key");

        // Create the cache
        Cache<String, String> cache = new Cache<>(config);

        // Store data in the cache
        cache.put(new net.sf.ehcache.Element("key", "sensitive_data"));

        // Ensure the cache is properly shut down to prevent data exposure
        cacheManager.shutdown();
    }
}
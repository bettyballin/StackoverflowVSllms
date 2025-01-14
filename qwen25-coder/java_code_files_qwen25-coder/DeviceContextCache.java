public class DeviceContextCache {
    public static void main(String[] args) {
        // Start an Ignite node.
        try (Ignite ignite = Ignition.start()) {
            // Create cache configuration for device contexts.
            CacheConfiguration<Integer, DeviceContext> cacheCfg = new CacheConfiguration<>("device-context-cache");
            cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);

            // Get or create a cache.
            var deviceContextCache = ignite.getOrCreateCache(cacheCfg);

            // Example of putting and getting a device context.
            int deviceId = 1;
            DeviceContext dc = new DeviceContext(deviceId, "device-info");
            deviceContextCache.put(deviceId, dc);
            
            DeviceContext retrievedDc = deviceContextCache.get(deviceId);
            System.out.println("Retrieved Device Context: " + retrievedDc);
        }
    }
}

class DeviceContext {
    private int id;
    private String info;

    public DeviceContext(int id, String info) {
        this.id = id;
        this.info = info;
    }

    @Override
    public String toString() {
        return "DeviceContext{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}

// Dummy implementations to make the code compile

class Ignition {
    public static Ignite start() {
        // Returning a new Ignite object
        return new Ignite();
    }
}

class Ignite implements AutoCloseable {
    @Override
    public void close() {
        // Do nothing
    }

    public <K, V> Cache<K, V> getOrCreateCache(CacheConfiguration<K, V> cacheCfg) {
        return new Cache<>();
    }
}

class CacheConfiguration<K, V> {
    public CacheConfiguration(String name) {
        // Constructor implementation
    }

    public void setAtomicityMode(CacheAtomicityMode mode) {
        // Method implementation
    }
}

enum CacheAtomicityMode {
    TRANSACTIONAL;
}

class Cache<K, V> {
    private java.util.Map<K, V> map = new java.util.HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}
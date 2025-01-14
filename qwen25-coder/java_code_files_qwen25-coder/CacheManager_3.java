import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager_3 {
    private static final ConcurrentHashMap<String, SomeData[]> cache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

    public static SomeData[] getCachedData(WebServiceInterface service, String email) {
        String key = "Data-" + email;
        SomeData[] data = cache.get(key);

        if (data == null) {
            // Get or create a unique lock object for this key
            Object lock = locks.computeIfAbsent(key, k -> new Object());

            synchronized (lock) {
                // Double check after acquiring the lock
                data = cache.get(key);
                if (data == null) {
                    data = service.getData(email); // Simulate fetching data
                    cache.put(key, data);

                    // Remove the lock to allow other threads to use it for updates in future
                    locks.remove(key);
                }
            }
        }

        return data;
    }

    public static void main(String[] args) {
        // For testing purposes, create a WebServiceInterface implementation
        WebServiceInterface service = new WebServiceImplementation();
        SomeData[] data = getCachedData(service, "test@example.com");
        System.out.println("Data length: " + data.length);
    }
}

// Define SomeData class
class SomeData {
    // For the purposes of making the code compile, we can leave this empty
}

// Define WebServiceInterface interface
interface WebServiceInterface {
    SomeData[] getData(String email);
}

// Implementation of WebServiceInterface for testing
class WebServiceImplementation implements WebServiceInterface {
    public SomeData[] getData(String email) {
        // Simulate fetching data
        return new SomeData[]{ new SomeData() };
    }
}
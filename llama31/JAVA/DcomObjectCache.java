import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Assuming DcomObject is an interface or class, I added a dummy implementation
class DcomObject {
    // Add your implementation here
}

public class DcomObjectCache {
    private final ConcurrentMap<String, DcomObject> cache = new ConcurrentHashMap<>();

    public DcomObject getDcomObject(String key) {
        DcomObject obj = cache.get(key);
        if (obj == null) {
            obj = createDcomObject(); // create a new DCOM object using J-Integra
            cache.put(key, obj);
        }
        return obj;
    }

    public void releaseDcomObject(String key) {
        cache.remove(key);
    }

    private DcomObject createDcomObject() {
        // create a new DCOM object using J-Integra
        return new DcomObject(); // dummy implementation
    }

    public static void main(String[] args) {
        DcomObjectCache cache = new DcomObjectCache();
        DcomObject obj = cache.getDcomObject("test");
        cache.releaseDcomObject("test");
    }
}
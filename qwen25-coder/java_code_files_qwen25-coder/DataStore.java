import java.util.Map;
import java.util.HashMap;

public class DataStore {
    private Map<String, Object> normalizedData; // Simulated database for normalized data
    private Map<String, DenormalizedData> cachedData; // Cache for denormalized data

    public DataStore() {
        normalizedData = new HashMap<String, Object>();
        cachedData = new HashMap<String, DenormalizedData>();
    }

    public void updateNormalizedData(String key, Object newData) {
        normalizedData.put(key, newData);
        invalidateCache(key); // Invalidate or refresh cache on update
    }

    public DenormalizedData getDenormalizedData(String key) {
        if (!cachedData.containsKey(key)) {
            cachedData.put(key, denormalize(normalizedData.get(key)));
        }
        return cachedData.get(key);
    }

    private void invalidateCache(String key) {
        cachedData.remove(key); // Simple cache invalidation
        // Consider more sophisticated strategies for partial updates and consistency
    }

    private DenormalizedData denormalize(Object normalized) {
        // Logic to convert normalized data into a denormalized form
        return new DenormalizedData(normalized);
    }

    public static void main(String[] args) {
        DataStore datastore = new DataStore();
        datastore.updateNormalizedData("key1", "someData");
        DenormalizedData data = datastore.getDenormalizedData("key1");
        System.out.println(data);
    }
}

class DenormalizedData {
    // Fields representing the denormalized structure
    private Object sourceData;

    public DenormalizedData(Object source) {
        // Initialization logic from normalized data
        this.sourceData = source;
    }

    public String toString() {
        return "DenormalizedData: " + sourceData.toString();
    }
}
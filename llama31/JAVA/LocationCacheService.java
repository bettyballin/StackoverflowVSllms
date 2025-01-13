import java.util.List;

public class LocationCacheService {
    private CacheManager cacheManager = CacheManager.getInstance();
    private Cache locationsCache = cacheManager.getCache("locations");

    public List<Location> getAllLocations() {
        if (!locationsCache.containsKey("allLocations")) {
            loadAllLocations();
        }
        return (List<Location>) locationsCache.get("allLocations");
    }

    public static void main(String[] args) {
    }
}
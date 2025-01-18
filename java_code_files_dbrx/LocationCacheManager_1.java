import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LocationCacheManager_1 {
    private Map<Long, Location> locationCache = new ConcurrentHashMap<>();

    public List<Location> getAllLocations() {
        if (locationCache.isEmpty()) {
            loadAllLocations();
        }
        return locationCache.values().stream().collect(Collectors.toList());
    }

    private void loadAllLocations()  {
        /* load all Locations */
    }

    public static void main(String[] args) {
    }
}

class Location {
    // Define Location class members here
}
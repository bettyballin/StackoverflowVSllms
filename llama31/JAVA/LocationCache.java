import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class LocationCache {
    private ConcurrentHashMap<String, Location> locations = new ConcurrentHashMap<>();

    public List<Location> getAllLocations() {
        if (locations.isEmpty()) {
            loadAllLocations();
        }
        return new ArrayList<>(locations.values());
    }

    // Assuming Location is a separate class, if not you need to define it
    private void loadAllLocations() {
        // You need to implement this method to load locations
        // For now, I'll just add a dummy location
        locations.put("dummy", new Location());
    }

    public static void main(String[] args) {
        LocationCache cache = new LocationCache();
        List<Location> locations = cache.getAllLocations();
        System.out.println(locations);
    }
}

// Assuming Location is a separate class
class Location {
    // Add properties and methods as needed
}
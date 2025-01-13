import java.util.List;
import org.springframework.cache.annotation.Cacheable;

public class LocationService {
    @Cacheable("locations")
    public List<Location> getAllLocations() {
        return loadAllLocations();
    }

    // Assuming loadAllLocations() is a method that returns a list of locations
    private List<Location> loadAllLocations() {
        // Implementation to load all locations
        return null; // Replace with actual implementation
    }

    public static void main(String[] args) {
        LocationService locationService = new LocationService();
        List<Location> locations = locationService.getAllLocations();
        // Do something with the locations
    }
}
import java.util.List;
import java.util.ArrayList;

// Define the LocationDAO interface
interface LocationDAO {
    List<Location> getAllLocations();
}

// Define the Location class
class Location {
    // Empty implementation
}

// Define the Cacheable annotation
@interface Cacheable {
    String value();
}

public class LocationDAOImpl_1 implements LocationDAO {

    @Override
    @Cacheable("locations")
    public List<Location> getAllLocations() {
        // Simulate database or other I/O operations
        return new ArrayList<>();
    }

    public static void main(String[] args) {
    }
}
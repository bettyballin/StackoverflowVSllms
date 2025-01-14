import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    private volatile List<Location> locations = null;
    private final Object lock = new Object();

    @Override
    public List<Location> getAllLocations() {
        if (locations == null) {
            synchronized (lock) {
                if (locations == null) {
                    loadAllLocations();
                }
            }
        }
        return locations;
    }

    private void loadAllLocations() {
        // Simulate database or other I/O operations
        locations = new ArrayList<>();
        // Add locations to the list
        // For example: locations.add(new Location(...));
    }

    public static void main(String[] args) {
    }
}

interface LocationDAO {
    List<Location> getAllLocations();
}

class Location {
    // Dummy class representing a location
}
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class LocationDAOImpl_2 implements LocationDAO {

    private final AtomicReference<List<Location>> locationsRef = new AtomicReference<>(null);
    private final Object lock = new Object();

    @Override
    public List<Location> getAllLocations() {
        List<Location> currentLocations = locationsRef.get();
        if (currentLocations == null) {
            synchronized (lock) {
                currentLocations = locationsRef.get();
                if (currentLocations == null) {
                    loadAllLocations();
                    currentLocations = locationsRef.get();
                }
            }
        }
        return currentLocations;
    }

    private void loadAllLocations() {
        // Simulate database or other I/O operations
        List<Location> newLocations = new ArrayList<>();
        // Add locations to the list
        // For example: newLocations.add(new Location(...));
        locationsRef.set(newLocations);
    }

    public static void main(String[] args) {
        LocationDAOImpl_2 dao = new LocationDAOImpl_2();
        List<Location> locations = dao.getAllLocations();
        System.out.println("Locations loaded: " + locations.size());
    }
}

interface LocationDAO {
    List<Location> getAllLocations();
}

class Location {
    // Dummy class for demonstration purposes
}
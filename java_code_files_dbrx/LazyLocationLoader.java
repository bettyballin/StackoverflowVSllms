import java.util.List;
import java.util.ArrayList;

public class LazyLocationLoader {
    private volatile List<Location> locationCache; // Volatile keyword ensures visibility of updates across threads

    public List<Location> getAllLocations() {
        if (locationCache == null) {
            synchronized(this) {
                if (locationCache == null) {
                    loadAllLocations();
                }
            }
        }
        return locationCache;
    }

    private void loadAllLocations() {
        // Dummy implementation to make it compile
        locationCache = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}

class Location {
    // Dummy class to make it compile
}
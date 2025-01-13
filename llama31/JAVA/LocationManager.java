import java.util.List;

class Location {
    // empty class to make the code compile
}

public class LocationManager {

    private volatile List<Location> locations = null;

    public List<Location> getAllLocations() {
        if (locations == null) {
            synchronized (this) {
                if (locations == null) {
                    loadAllLocations();
                }
            }
        }
        return locations;
    }

    private void loadAllLocations() {
        // empty method to make the code compile
    }

    public static void main(String[] args) {
    }
}
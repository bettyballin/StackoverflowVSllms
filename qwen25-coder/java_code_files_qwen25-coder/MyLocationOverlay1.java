public class MyLocationOverlay1 extends MyLocationOverlay {

    @Override
    public void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when) {
        super.drawMyLocation(canvas, mapView, lastFix, myLocation, when);

        // Convert microdegrees to decimal degrees
        double latB = FindList.gpslat / 1E6;
        double lonB = FindList.gpslong / 1E6;
        double latA = myLocation.getLatitudeE6() / 1E6;
        double lonA = myLocation.getLongitudeE6() / 1E6;

        Location bLocation = new Location("reverseGeocoded");
        bLocation.setLatitude(latB);
        bLocation.setLongitude(lonB);

        Location aLocation = new Location("reverseGeocoded");
        aLocation.setLatitude(latA);
        aLocation.setLongitude(lonA);

        int distance = (int)aLocation.distanceTo(bLocation); // This should now give the correct distance in meters
        String str = " (" + String.valueOf(distance) + " meters)";
    }

    public static void main(String[] args) {
        // Main method can remain empty or include test code
    }
}

class MyLocationOverlay {
    public void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when) {
        // Base method implementation (could be empty)
    }
}

class Canvas {
    // Empty stub class for Canvas
}

class MapView {
    // Empty stub class for MapView
}

class Location {
    private double latitude;
    private double longitude;

    public Location(String provider) {
        // Constructor
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float distanceTo(Location dest) {
        // Stub method for distance calculation
        return 0;
    }
}

class GeoPoint {
    public int getLatitudeE6() {
        return 0;
    }

    public int getLongitudeE6() {
        return 0;
    }
}

class FindList {
    public static double gpslat = 0;  // Provide default values or replacements
    public static double gpslong = 0;
}
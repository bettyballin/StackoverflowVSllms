import android.location.Location;

public class GeoDistanceCalculator {
    public static void main(String[] args) {
        // Assuming myLocation and FindList are defined somewhere
        Location myLocation = new Location("reverseGeocoded");
        myLocation.setLatitude(37.7749 * 1E6); // Example latitude in microdegrees
        myLocation.setLongitude(-122.4194 * 1E6); // Example longitude in microdegrees

        Location bLocation = new Location("reverseGeocoded");
        bLocation.setLatitude(37.8024 * 1E6); // Example latitude in microdegrees
        bLocation.setLongitude(-122.4056 * 1E6); // Example longitude in microdegrees

        Location aLocation = new Location("reverseGeocoded");
        aLocation.setLatitude(myLocation.getLatitude());
        aLocation.setLongitude(myLocation.getLongitude());

        int distance = (int)aLocation.distanceTo(bLocation);
        System.out.println("Distance: " + distance + " meters");
    }
}
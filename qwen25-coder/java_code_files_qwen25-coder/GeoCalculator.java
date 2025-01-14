import java.lang.String;
public class GeoCalculator {
    public static double[] calculateDestination(double lat, double lon, double bearing, double distance) {
        // Radius of the Earth in kilometers
        final double R = 6371.0;
        
        // Convert distance to radians (using Earth's radius in kilometers)
        double radDist = distance / R;

        // Convert latitude and bearing from degrees to radians
        lat = Math.toRadians(lat);
        bearing = Math.toRadians(bearing);

        // Calculate new latitude
        double newLat = Math.asin(Math.sin(lat) * Math.cos(radDist) +
                                  Math.cos(lat) * Math.sin(radDist) * Math.cos(bearing));

        // Calculate new longitude
        double newLon = lon + Math.atan2(Math.sin(bearing) * Math.sin(radDist) * Math.cos(lat),
                                         Math.cos(radDist) - Math.sin(lat) * Math.sin(newLat));
        
        // Convert new latitude and longitude from radians to degrees
        newLat = Math.toDegrees(newLat);
        newLon = Math.toDegrees(newLon);

        return new double[]{newLat, newLon};
    }
    public static void main(String[] args) {
    }
}
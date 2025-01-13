import java.lang.Math;

public class GeoCalculator_3_3 {
    public static void calculateNewPosition(double lat1, double lon1, double heading, double distance) {
        double lat1Rad = toRadians(lat1);
        double lon1Rad = toRadians(lon1);
        double headingRad = toRadians(heading);

        double distanceKM = distance / 1000; // convert distance to kilometers
        double radiusEarthKM = 6371; // Earth's radius in kilometers

        double lat2Rad = Math.asin(Math.sin(lat1Rad) * Math.cos(distanceKM / radiusEarthKM) +
                              Math.cos(lat1Rad) * Math.sin(distanceKM / radiusEarthKM) * Math.cos(headingRad));
        double lon2Rad = lon1Rad + Math.atan2(Math.sin(headingRad) * Math.sin(distanceKM / radiusEarthKM) * Math.cos(lat1Rad),
                                        Math.cos(distanceKM / radiusEarthKM) - Math.sin(lat1Rad) * Math.sin(lat2Rad));

        double lat2 = toDegrees(lat2Rad);
        double lon2 = toDegrees(lon2Rad);

        System.out.println("New position: (" + lat2 + ", " + lon2 + ")");
    }

    public static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double toDegrees(double radians) {
        return radians * 180 / Math.PI;
    }

    public static void main(String[] args) {
        // Example usage:
        calculateNewPosition(37.7749, -122.4194, 45, 1000);
    }
}
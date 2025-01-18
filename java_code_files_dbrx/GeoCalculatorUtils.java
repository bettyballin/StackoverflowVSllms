public class CalculateDestination {

    public static double[] calculateDestination(double lat1, double lon1, double brng, double dist) {
        // Convert angles in degrees to radians
        brng = Math.toRadians(brng);
        dist = dist / 3954;   // convert miles to kilometers
        final int RRR = 6372800; // radius of earth in meters (WGS-84 ellipsoid, close enough for this)
        double lat1r = Math.toRadians(lat1);
        double lon1r = Math.toRadians(lon1);
        double crs1 = Math.cos(brng), csb = Math.sin(brng);
        double sinLat1 = Math.sin(lat1r), cosLat1 = Math.cos(lat1r);

        // Derive other angles needed from the above
        double lat2 = Math.atan2(
            sinLat1 * crs1 + cosLat1 * csb * Math.cos(dist / RRR),
            sinLat1 * csb - cosLat1 * crs1 * Math.cos(dist / RRR)
        );

        double lon2 = lon1r + Math.atan2(
            csb * Math.sin(dist / RRR),
            crs1 - sinLat1 * Math.sin(lat2)
        );

        // Normalize the results (i.e., limit from -180 to +180 degrees & negate if needed)
        lon2 = Math.toDegrees(lon2);
        lon2 = ((lon2 % 360) + 540) % 360 - 180;   // normalize longitude
        lat2 = Math.toDegrees(lat2);

        return new double[] {lat2, lon2};
    }

    public static void main(String[] args) {
        double lat1 = 37.7749; // Example latitude in degrees (e.g., San Francisco)
        double lon1 = -122.4194; // Example longitude in degrees
        double brng = 45; // Bearing in degrees
        double dist = 100; // Distance in miles

        double[] destination = calculateDestination(lat1, lon1, brng, dist);

        System.out.println("Destination Latitude: " + destination[0]);
        System.out.println("Destination Longitude: " + destination[1]);
    }
}
public class RadialGeodesyUtil {
    private static double[] pointRadialDistance(double lat1, double lon1, 
            double radianBearing, double radialDistance) {
        // Radius of the Earth in kilometers
        final double EARTH_RADIUS_KM = 6371.0;

        // Convert latitude and longitude from degrees to radians
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);

        // Calculate new latitude
        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(radialDistance / EARTH_RADIUS_KM) +
                Math.cos(lat1) * Math.sin(radialDistance / EARTH_RADIUS_KM) * Math.cos(radianBearing));

        // Calculate new longitude
        double lonChange = Math.atan2(
                Math.sin(radianBearing) * Math.sin(radialDistance / EARTH_RADIUS_KM) * Math.cos(lat1),
                Math.cos(radialDistance / EARTH_RADIUS_KM) - Math.sin(lat1) * Math.sin(lat2));
        double lon2 = (lon1 + lonChange + 3 * Math.PI) % (2 * Math.PI) - Math.PI; // Normalize to (-π, π)

        return new double[]{Math.toDegrees(lat2), Math.toDegrees(lon2)};
    }
    public static void main(String[] args) {
    }
}
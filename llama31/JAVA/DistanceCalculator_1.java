import java.lang.String;
import java.lang.Math;

public class DistanceCalculator_1 {
    private static final double EARTH_RADIUS = 6371; // in kilometers

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = toRadians(lat2 - lat1);
        double dLon = toRadians(lon2 - lon1);

        double lat1Rad = toRadians(lat1);
        double lat2Rad = toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1Rad) * Math.cos(lat2Rad);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    private static double toRadians(double deg) {
        return deg * Math.PI / 180;
    }

    public static void main(String[] args) {
        double lat1 = 52.5200; // Berlin
        double lon1 = 13.4050;
        double lat2 = 48.8566; // Paris
        double lon2 = 2.3522;

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distance between Berlin and Paris: " + distance + " km");
    }
}
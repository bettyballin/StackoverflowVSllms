import java.lang.Math;

public class GeoCalculator {

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return (dist);
    }

    public static void main(String[] args) {
        GeoCalculator geoCalculator = new GeoCalculator();
        double lat1 = 40.7128;
        double lon1 = 74.0060;
        double lat2 = 34.0522;
        double lon2 = 118.2437;
        double distance = geoCalculator.getDistance(lat1, lon1, lat2, lon2);
        System.out.println("The distance between the two points is: " + distance);
    }
}
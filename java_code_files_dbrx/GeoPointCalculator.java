import java.lang.String;
public class GeoPointCalculator {
    private static double[] pointRadialDistance(double lat1, double lon1, double radianBearing, double radialDistance) {
        // convert distance in km to meters and then to radians (assume circumference as 6371km or 6.371e+6m)
        radialDistance = radialDistance / 6371000 * Math.PI;
        double lat2 = Math.asin(Math.sin(lat1)*Math.cos(radialDistance)+Math.cos(lat1)*Math.sin(radialDistance)*Math.cos(radianBearing));
        double lon2;
        if (Math.cos(lat2) == 0){ // Endpoint is a pole
            lon2 = lon1;
        } else {
            lon2 = ((lon1 - Math.asin(Math.sin(radianBearing)*Math.sin(radialDistance)/Math.cos(lat2)) + Math.PI ) % (2*Math.PI) ) - Math.PI;
        }
        return new double[]{Math.toDegrees(lat2), Math.toDegrees(lon2)}; // return to degrees
    }
    public static void main(String[] args) {
    }
}
import java.lang.Math;

public class GeoCalculator_1_1 {
    private static double[] pointRadialDistance(double lat1, double lon1, 
            double radianBearing, double radialDistance) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        
        double lat = Math.asin(Math.sin(lat1)*Math.cos(radialDistance)+Math.cos(lat1)
                *Math.sin(radialDistance)*Math.cos(radianBearing));
        double lon;
        if(Math.cos(lat) == 0) {  // Endpoint a pole
           lon=lon1;      
        }
        else {
           lon = ((lon1-Math.asin(Math.sin(radianBearing)*Math.sin(radialDistance)/Math.cos(lat))
                   +Math.PI) % (2*Math.PI)) - Math.PI;
        }
       return (new double[]{Math.toDegrees(lat), Math.toDegrees(lon)});
    }
    public static void main(String[] args) {
        // Example usage:
        double lat1 = 37.7749;
        double lon1 = -122.4194;
        double radianBearing = Math.toRadians(45); // 45 degrees in radians
        double radialDistance = 100 / 6371; // 100 km in radians (6371 km is Earth's radius)
        double[] result = pointRadialDistance(lat1, lon1, radianBearing, radialDistance);
        System.out.println("New point: (" + result[0] + ", " + result[1] + ")");
    }
}
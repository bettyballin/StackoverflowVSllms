import java.lang.String;

public class GeoCalculator_4_4 {

    public static void calculateNewPosition(double latitude, double longitude, double bearing, double distance) {
        // implementation of calculateNewPosition method is missing
        System.out.println("New position: " + latitude + ", " + longitude + ", bearing: " + bearing + ", distance: " + distance);
    }

    public static void main(String[] args) {
        GeoCalculator_4 calculator = new GeoCalculator_4();
        calculator.calculateNewPosition(37.7749, -122.4194, 45.0, 10000.0);
    }
}
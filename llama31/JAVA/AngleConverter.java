import java.lang.Math;

public class AngleConverter {
    public double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public static void main(String[] args) {
        AngleConverter converter = new AngleConverter();
        double degrees = 45.0;
        double radians = converter.deg2rad(degrees);
        System.out.println(degrees + " degrees is equal to " + radians + " radians");

        radians = Math.PI / 2;
        degrees = converter.rad2deg(radians);
        System.out.println(radians + " radians is equal to " + degrees + " degrees");
    }
}
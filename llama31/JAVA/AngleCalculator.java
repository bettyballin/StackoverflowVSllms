import java.lang.String;
import java.lang.Math;

public class AngleCalculator {
    public static double calculateAngle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = distance(x1, y1, x2, y2);
        double b = distance(x1, y1, x3, y3);
        double c = distance(x2, y2, x3, y3);
        return Math.acos((a * a + b * b - c * c) / (2 * a * b));
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

	public static void main(String[] args) {
	}
}
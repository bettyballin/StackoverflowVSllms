import java.lang.String;
public class CirclePointCalculator {
    public static double[] pointOnCircle(double radius, double angleDegrees, double[] origin) {
        double angleRadians = Math.toRadians(angleDegrees);
        double x = origin[0] + radius * Math.cos(angleRadians);
        double y = origin[1] + radius * Math.sin(angleRadians);
        return new double[]{x, y};
    }

	public static void main(String[] args) {
	}
}
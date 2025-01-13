import java.lang.String;
public class CirclePointCalculator {
    public static double[] calculatePoint(double radius, double angle, double[] origin) {
        double x = radius * Math.cos(angle) + (origin != null ? origin[0] : 0);
        double y = radius * Math.sin(angle) + (origin != null ? origin[1] : 0);
        return new double[] { x, y };
    }

	public static void main(String[] args) {
	}
}
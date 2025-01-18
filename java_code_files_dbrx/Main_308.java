import java.lang.String;
import java.lang.Math;

public class Main_308 {
    public static double[] calculatePoint(double radius, double angle, double[] origin) {
        double x = radius * Math.cos(angle) + origin[0];
        double y = radius * Math.sin(angle) + origin[1];
        return new double[]{x, y};
    }

	public static void main(String[] args) {
	}
}
import java.lang.String;
public class AngleConverter_1 {
    public static double radiansToDegrees(double radians) {
        return radians * (180 / Math.PI);
    }

    public static double degreesToRadians(double degrees) {
        return degrees * (Math.PI / 180);
    }

	public static void main(String[] args) {
	}
}
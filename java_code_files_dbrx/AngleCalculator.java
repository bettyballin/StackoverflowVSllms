import java.lang.String;

public class AngleCalculator {
    double pacManX;
    double pacManY;
    double ghostX;
    double ghostY;

    double dx = pacManX - ghostX;
    double dy = pacManY - ghostY;
    double angleRadians = Math.atan2(dy, dx);

    public static void main(String[] args) {
    }
}
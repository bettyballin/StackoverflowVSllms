import java.lang.String;
public class AngleCalculator {

    public static double calculateAngle(Point p1, Point p2, Point p3) {
        // Vectors P1P2 and P1P3
        int x1 = p2.x - p1.x;
        int y1 = p2.y - p1.y;
        int x2 = p3.x - p1.x;
        int y2 = p3.y - p1.y;

        // Dot product of vectors P1P2 and P1P3
        double dotProduct = (x1 * x2) + (y1 * y2);

        // Magnitudes of vectors P1P2 and P1P3
        double magnitude1 = Math.sqrt((x1 * x1) + (y1 * y1));
        double magnitude2 = Math.sqrt((x2 * x2) + (y2 * y2));

        // Cosine of angle between vectors
        double cosAngle = dotProduct / (magnitude1 * magnitude2);

        // Angle in radians and then converted to degrees
        double angleRadians = Math.acos(cosAngle);
        return Math.toDegrees(angleRadians);
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 50);
        Point p2 = new Point(9, 40);
        Point p3 = new Point(5, 20);

        double angle = calculateAngle(p1, p2, p3);
        System.out.println("The angle is: " + angle + " degrees");
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
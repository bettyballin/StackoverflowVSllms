import java.lang.String;
import java.util.Optional;

public class ProjectionCalculator {
    public double xProjection(Optional<Point> op1, Optional<Point> op2) {
        Point p1 = op1.orElseThrow(() -> new IllegalArgumentException("First point must be present"));
        Point p2 = op2.orElseThrow(() -> new IllegalArgumentException("Second point must be present"));
        return (p2.x - p1.x) * 1.5;
    }

    public static void main(String[] args) {
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
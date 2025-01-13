import java.util.Objects;

class Point {
    public double x;
}

public class MetricsCalculator {
    public double xProjection(Point p1, Point p2) {
        Objects.requireNonNull(p1, "p1 is null");
        Objects.requireNonNull(p2, "p2 is null");
        return (p2.x - p1.x) * 1.5;
    }

    public static void main(String[] args) {
    }
}
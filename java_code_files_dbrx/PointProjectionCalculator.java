import java.lang.String;
public class PointProjectionCalculator {
    public double xProjection(Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Invalid argument for xProjection");
        }
        return (p2.x - p1.x) * 1.5;
    }
    public static void main(String[] args) {
    }

    static class Point {
        public double x;
        public double y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
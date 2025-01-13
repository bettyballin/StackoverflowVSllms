import java.lang.String;
import java.util.Arrays;

public class Main_531 {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double atan2(Point p, Point centroid) {
        return Math.atan2(p.y - centroid.y, p.x - centroid.x);
    }

    static void sortPoints(Point[] points) {
        Point centroid = new Point(0, 0);
        for (Point p : points) {
            centroid.x += p.x;
            centroid.y += p.y;
        }
        centroid.x /= points.length;
        centroid.y /= points.length;

        Arrays.sort(points, (a, b) -> Double.compare(atan2(a, centroid), atan2(b, centroid)));
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(1, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(3, 1)
        };

        sortPoints(points);

        for (Point p : points) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
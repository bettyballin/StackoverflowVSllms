import java.util.ArrayList;
import java.util.List;

public class ConvexHull {
    public static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n < 3) {
            return points;
        }

        List<Point> hull = new ArrayList<>();

        // Find the leftmost point
        Point leftmost = points.get(0);
        for (int i = 1; i < n; i++) {
            if (points.get(i).x < leftmost.x) {
                leftmost = points.get(i);
            }
        }

        // Start from the leftmost point and keep choosing the next point in a counter-clockwise direction
        Point p = leftmost;
        do {
            hull.add(p);
            Point q = null;
            for (Point r : points) {
                if (r == p) {
                    continue;
                }
                if (q == null || orientation(p, q, r) < 0) {
                    q = r;
                }
            }
            p = q;
        } while (p != leftmost);

        return hull;
    }

    private static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) {
            return 0; // Collinear
        }
        return val > 0 ? 1 : -1; // Clockwise or counter-clockwise
    }

    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 3));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        points.add(new Point(0, 0));
        points.add(new Point(1, 2));
        points.add(new Point(3, 1));
        points.add(new Point(3, 3));

        List<Point> hull = convexHull(points);
        for (Point point : hull) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
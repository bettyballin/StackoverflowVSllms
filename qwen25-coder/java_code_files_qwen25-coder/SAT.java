import java.lang.String;
public class SAT {
    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
        
        // Vector subtraction
        public static Point subtract(Point a, Point b) {
            return new Point(a.x - b.x, a.y - b.y);
        }

        // Dot product
        public static double dotProduct(Point a, Point b) {
            return a.x * b.x + a.y * b.y;
        }
    }

    // Project all points onto the normal vector and check for overlap
    private static boolean doOverlapOnAxis(Point[] rect1, Point[] rect2, Point axis) {
        double min1 = Double.MAX_VALUE, max1 = -Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE, max2 = -Double.MAX_VALUE;

        for (Point p : rect1) {
            double projection = Point.dotProduct(p, axis);
            if (projection < min1) min1 = projection;
            if (projection > max1) max1 = projection;
        }

        for (Point p : rect2) {
            double projection = Point.dotProduct(p, axis);
            if (projection < min2) min2 = projection;
            if (projection > max2) max2 = projection;
        }

        return !(max1 < min2 || min1 > max2);
    }

    // Check for intersection using SAT
    public static boolean doIntersect(Point[] rect1, Point[] rect2) {
        for (int i = 0; i < rect1.length; i++) {
            Point edge = Point.subtract(rect1[(i + 1) % rect1.length], rect1[i]);
            Point axis = new Point(-edge.y, edge.x); // Perpendicular vector

            if (!doOverlapOnAxis(rect1, rect2, axis)) return false;
        }

        for (int i = 0; i < rect2.length; i++) {
            Point edge = Point.subtract(rect2[(i + 1) % rect2.length], rect2[i]);
            Point axis = new Point(-edge.y, edge.x); // Perpendicular vector

            if (!doOverlapOnAxis(rect1, rect2, axis)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Define points for R1 and R2
        Point[] R1 = { new Point(0, 0), new Point(3, 0), new Point(4, 2), new Point(1, 2)};
        Point[] R2 = { new Point(2, -1), new Point(5, -1), new Point(5, 1), new Point(2, 1)};

        System.out.println("Rectangles intersect: " + doIntersect(R1, R2));
    }
}
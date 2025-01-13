import java.lang.String;
public class ConvexHull_1 {
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isConvex(Point[] points) {
        int n = points.length;
        if (n < 3) return true; // 0, 1 or 2 points are always convex

        // Find the leftmost point
        int leftmost = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[leftmost].x) {
                leftmost = i;
            }
        }

        int p = leftmost;
        int q = 0;
        do {
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) > 0) {
                    q = i;
                }
            }

            p = q;
        } while (p != leftmost);

        return true; // we have checked all points and didn't find any non-convex
    }

    private static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

	public static void main(String[] args) {
	}
}
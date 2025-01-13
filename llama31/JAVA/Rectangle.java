import java.lang.String;

class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D normal() {
        return new Vector2D(-y, x);
    }

    public double dot(Vector2D other) {
        return x * other.x + y * other.y;
    }
}

public class Rectangle {
    public Vector2D[] corners = new Vector2D[4];

    public Rectangle(Vector2D p1, Vector2D p2, Vector2D p3, Vector2D p4) {
        corners[0] = p1;
        corners[1] = p2;
        corners[2] = p3;
        corners[3] = p4;
    }

    public boolean intersects(Rectangle other) {
        // Check if the two rectangles intersect using the Separating Axis Theorem
        // Iterate over all edges of both rectangles
        for (int i = 0; i < 4; i++) {
            Vector2D edge = corners[(i + 1) % 4].subtract(corners[i]);
            Vector2D axis = edge.normal();

            // Project both rectangles onto the axis
            double min1 = Double.POSITIVE_INFINITY;
            double max1 = Double.NEGATIVE_INFINITY;
            for (Vector2D corner : corners) {
                double proj = corner.dot(axis);
                min1 = Math.min(min1, proj);
                max1 = Math.max(max1, proj);
            }

            double min2 = Double.POSITIVE_INFINITY;
            double max2 = Double.NEGATIVE_INFINITY;
            for (Vector2D corner : other.corners) {
                double proj = corner.dot(axis);
                min2 = Math.min(min2, proj);
                max2 = Math.max(max2, proj);
            }

            // Check if the projections overlap
            if (max1 < min2 || max2 < min1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Vector2D p1 = new Vector2D(0, 0);
        Vector2D p2 = new Vector2D(1, 0);
        Vector2D p3 = new Vector2D(1, 1);
        Vector2D p4 = new Vector2D(0, 1);

        Rectangle rect1 = new Rectangle(p1, p2, p3, p4);

        Vector2D p5 = new Vector2D(0.5, 0);
        Vector2D p6 = new Vector2D(1.5, 0);
        Vector2D p7 = new Vector2D(1.5, 1);
        Vector2D p8 = new Vector2D(0.5, 1);

        Rectangle rect2 = new Rectangle(p5, p6, p7, p8);

        System.out.println(rect1.intersects(rect2));
    }
}
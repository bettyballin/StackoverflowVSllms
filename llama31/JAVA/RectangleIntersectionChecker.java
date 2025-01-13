import java.lang.String;

class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Rectangle {
    private Vector2D topLeft;
    private Vector2D topRight;
    private Vector2D bottomRight;
    private Vector2D bottomLeft;

    public Rectangle(Vector2D topLeft, Vector2D topRight, Vector2D bottomRight, Vector2D bottomLeft) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }

    public boolean intersects(Rectangle other) {
        // Simple rectangle intersection check
        return (this.topLeft.getX() < other.topRight.getX() &&
                this.topRight.getX() > other.topLeft.getX() &&
                this.topLeft.getY() < other.bottomLeft.getY() &&
                this.bottomLeft.getY() > other.topLeft.getY());
    }
}

public class RectangleIntersectionChecker {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(
            new Vector2D(0, 0),
            new Vector2D(10, 0),
            new Vector2D(10, 10),
            new Vector2D(0, 10)
        );

        Rectangle rect2 = new Rectangle(
            new Vector2D(5, 5),
            new Vector2D(15, 5),
            new Vector2D(15, 15),
            new Vector2D(5, 15)
        );

        if (rect1.intersects(rect2)) {
            System.out.println("Rectangles intersect!");
        } else {
            System.out.println("Rectangles do not intersect.");
        }
    }
}
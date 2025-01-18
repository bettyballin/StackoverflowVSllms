import java.awt.Point;
import java.awt.Shape;
import java.util.List;

public class VisibilityChecker {
    public static boolean lineOfSight(Point p1, Point p2, List<Shape> obstacles) {
        for (Shape shape : obstacles) {
            if (intersects(p1, p2, shape)) {
                return false; // Obstacle found.
            }
        }
        return true;  // Line of sight is clear between the two points.
    }

    private static boolean intersects(Point p1, Point p2, Shape shape) {
        // Dummy implementation for compilation
        return false;
    }

    public static void main(String[] args) {
    }
}
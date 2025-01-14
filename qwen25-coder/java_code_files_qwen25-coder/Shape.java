import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Rectangle;

public class Shape {

    abstract class ShapeBase {
        int zIndex;
        Rectangle bounds;

        abstract boolean containsPoint(Point point); // implementation based on shape type
    }

    List<ShapeBase> shapes = new ArrayList<>(); // Assume shapes are added and sorted by zIndex

    public ShapeBase selectShapeAtPoint(Point clickPoint) {
        for (int i = shapes.size() - 1; i >= 0; i--) { // Iterate from top to bottom
            ShapeBase shape = shapes.get(i);
            if (shape.bounds.contains(clickPoint)) { // Fast bounding box check
                if (shape.containsPoint(clickPoint)) { // Precise collision test
                    return shape;
                }
            }
        }
        return null; // No shape found at click point
    }

    public static void main(String[] args) {
    }
}
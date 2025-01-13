import java.util.List;
import java.util.ArrayList;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    // Add relevant fields and methods for Rectangle class
}

public class OrthogonalEdgeRouter {
    public static List<Point> routeEdge(Rectangle startBounds, Point startAnchor, 
                                        Rectangle endBounds, Point endAnchor) {
        List<Point> points = new ArrayList<>();

        // Calculate the Manhattan distance between the two anchors
        int dx = Math.abs(endAnchor.x - startAnchor.x);
        int dy = Math.abs(endAnchor.y - startAnchor.y);

        // Determine the direction of the edge
        int directionX = (endAnchor.x > startAnchor.x) ? 1 : -1;
        int directionY = (endAnchor.y > startAnchor.y) ? 1 : -1;

        // Route the edge
        if (dx > dy) {
            // Horizontal edge
            points.add(startAnchor);
            points.add(new Point(startAnchor.x + dx * directionX, startAnchor.y));
            points.add(new Point(endAnchor.x, startAnchor.y));
            points.add(endAnchor);
        } else {
            // Vertical edge
            points.add(startAnchor);
            points.add(new Point(startAnchor.x, startAnchor.y + dy * directionY));
            points.add(new Point(startAnchor.x, endAnchor.y));
            points.add(endAnchor);
        }

        return points;
    }

    public static void main(String[] args) {
        // Add test cases or usage examples here
    }
}
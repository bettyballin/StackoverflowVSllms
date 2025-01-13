import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public class EdgeRouterExample {
    public static void main(String[] args) {
        Rectangle startBounds = new Rectangle(10, 10, 50, 50);
        Point startAnchor = new Point(30, 30);

        Rectangle endBounds = new Rectangle(100, 100, 50, 50);
        Point endAnchor = new Point(120, 120);

        List<Point> points = OrthogonalEdgeRouter.routeEdge(startBounds, startAnchor, endBounds, endAnchor);
    }
}

class OrthogonalEdgeRouter {
    public static List<Point> routeEdge(Rectangle startBounds, Point startAnchor, Rectangle endBounds, Point endAnchor) {
        // You need to implement the logic for routing the edge here
        // For now, I'm just returning an empty list
        return List.of();
    }
}
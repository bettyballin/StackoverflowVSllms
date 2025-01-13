/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public class EdgeRouterExample {
    public static void main(String[] stringArray) {
        Rectangle rectangle = new Rectangle(10, 10, 50, 50);
        Point point = new Point(30, 30);
        Rectangle rectangle2 = new Rectangle(100, 100, 50, 50);
        Point point2 = new Point(120, 120);
        List list = OrthogonalEdgeRouter.routeEdge((Rectangle)rectangle, (Point)point, (Rectangle)rectangle2, (Point)point2);
    }
}

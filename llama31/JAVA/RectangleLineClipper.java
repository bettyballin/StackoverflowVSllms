import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class RectangleLineClipper {
    public Line2D clipLine(Rectangle2D rect, Line2D line) {
        double x1 = line.getX1();
        double y1 = line.getY1();
        double x2 = line.getX2();
        double y2 = line.getY2();
        
        // Get the intersection points between the line and the rectangle
        double dx = x2 - x1;
        double dy = y2 - y1;
        double t1 = rect.getMinX() - x1;
        double t2 = rect.getMaxX() - x1;
        double t3 = rect.getMinY() - y1;
        double t4 = rect.getMaxY() - y1;
        
        if (dy == 0) {
            // Horizontal line
            if (y1 < rect.getMinY() || y1 > rect.getMaxY()) {
                return new Line2D.Double(0, 0, 0, 0);
            } else {
                t1 = Math.max(t1, 0);
                t2 = Math.min(t2, dx);
                return new Line2D.Double(x1 + t1, y1, x1 + t2, y1);
            }
        } else if (dx == 0) {
            // Vertical line
            if (x1 < rect.getMinX() || x1 > rect.getMaxX()) {
                return new Line2D.Double(0, 0, 0, 0);
            } else {
                t3 = Math.max(t3, 0);
                t4 = Math.min(t4, dy);
                return new Line2D.Double(x1, y1 + t3, x1, y1 + t4);
            }
        } else {
            // Non-horizontal, non-vertical line
            double t5 = t3 / dy;
            double t6 = t4 / dy;
            t1 = Math.max(t1, 0);
            t2 = Math.min(t2, dx);
            t3 = Math.max(t5, 0);
            t4 = Math.min(t6, 1);
            t5 = Math.max(t1, t3);
            t6 = Math.min(t2, t4);
            
            if (t5 > t6) {
                return new Line2D.Double(0, 0, 0, 0);
            } else {
                return new Line2D.Double(x1 + t5 * dx, y1 + t5 * dy, x1 + t6 * dx, y1 + t6 * dy);
            }
        }
    }

    public static void main(String[] args) {
        RectangleLineClipper clipper = new RectangleLineClipper();
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 10, 10);
        Line2D line = new Line2D.Double(-5, -5, 15, 15);
        Line2D clippedLine = clipper.clipLine(rect, line);
        System.out.println(clippedLine.getP1() + " " + clippedLine.getP2());
    }
}
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class LineClipper {
    public Line2D clipLine(Rectangle2D rect, Line2D line) {
        Area area = new Area(rect);
        Area lineArea = new Area(new Rectangle2D.Double(line.getX1(), line.getY1(), line.getX2() - line.getX1(), line.getY2() - line.getY1()));
        area.intersect(lineArea);
        
        if (area.isEmpty()) {
            return new Line2D.Double(0, 0, 0, 0);
        } else {
            // Get the bounds of the clipped line
            Rectangle2D bounds = area.getBounds2D();
            
            // Create a new line based on the bounds
            return new Line2D.Double(bounds.getMinX(), bounds.getMinY(), bounds.getMaxX(), bounds.getMaxY());
        }
    }

    public static void main(String[] args) {
        LineClipper clipper = new LineClipper();
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 10, 10);
        Line2D line = new Line2D.Double(5, 5, 15, 15);
        Line2D clippedLine = clipper.clipLine(rect, line);
        System.out.println("Clipped line: " + clippedLine);
    }
}
/*
 * Decompiled with CFR 0.152.
 */
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class LineClipper {
    public Line2D clipLine(Rectangle2D rectangle2D, Line2D line2D) {
        Area area = new Area(rectangle2D);
        Area area2 = new Area(new Rectangle2D.Double(line2D.getX1(), line2D.getY1(), line2D.getX2() - line2D.getX1(), line2D.getY2() - line2D.getY1()));
        area.intersect(area2);
        if (area.isEmpty()) {
            return new Line2D.Double(0.0, 0.0, 0.0, 0.0);
        }
        Rectangle2D rectangle2D2 = area.getBounds2D();
        return new Line2D.Double(rectangle2D2.getMinX(), rectangle2D2.getMinY(), rectangle2D2.getMaxX(), rectangle2D2.getMaxY());
    }

    public static void main(String[] stringArray) {
        LineClipper lineClipper = new LineClipper();
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, 10.0, 10.0);
        Line2D.Double double_2 = new Line2D.Double(5.0, 5.0, 15.0, 15.0);
        Line2D line2D = lineClipper.clipLine(double_, double_2);
        System.out.println("Clipped line: " + String.valueOf(line2D));
    }
}

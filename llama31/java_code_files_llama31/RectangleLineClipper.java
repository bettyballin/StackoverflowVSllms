/*
 * Decompiled with CFR 0.152.
 */
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class RectangleLineClipper {
    public Line2D clipLine(Rectangle2D rectangle2D, Line2D line2D) {
        double d = line2D.getX1();
        double d2 = line2D.getY1();
        double d3 = line2D.getX2();
        double d4 = line2D.getY2();
        double d5 = d3 - d;
        double d6 = d4 - d2;
        double d7 = rectangle2D.getMinX() - d;
        double d8 = rectangle2D.getMaxX() - d;
        double d9 = rectangle2D.getMinY() - d2;
        double d10 = rectangle2D.getMaxY() - d2;
        if (d6 == 0.0) {
            if (d2 < rectangle2D.getMinY() || d2 > rectangle2D.getMaxY()) {
                return new Line2D.Double(0.0, 0.0, 0.0, 0.0);
            }
            d7 = Math.max(d7, 0.0);
            d8 = Math.min(d8, d5);
            return new Line2D.Double(d + d7, d2, d + d8, d2);
        }
        if (d5 == 0.0) {
            if (d < rectangle2D.getMinX() || d > rectangle2D.getMaxX()) {
                return new Line2D.Double(0.0, 0.0, 0.0, 0.0);
            }
            d9 = Math.max(d9, 0.0);
            d10 = Math.min(d10, d6);
            return new Line2D.Double(d, d2 + d9, d, d2 + d10);
        }
        double d11 = d9 / d6;
        double d12 = d10 / d6;
        d7 = Math.max(d7, 0.0);
        d8 = Math.min(d8, d5);
        d9 = Math.max(d11, 0.0);
        d10 = Math.min(d12, 1.0);
        d11 = Math.max(d7, d9);
        if (d11 > (d12 = Math.min(d8, d10))) {
            return new Line2D.Double(0.0, 0.0, 0.0, 0.0);
        }
        return new Line2D.Double(d + d11 * d5, d2 + d11 * d6, d + d12 * d5, d2 + d12 * d6);
    }

    public static void main(String[] stringArray) {
        RectangleLineClipper rectangleLineClipper = new RectangleLineClipper();
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, 10.0, 10.0);
        Line2D.Double double_2 = new Line2D.Double(-5.0, -5.0, 15.0, 15.0);
        Line2D line2D = rectangleLineClipper.clipLine(double_, double_2);
        System.out.println(String.valueOf(line2D.getP1()) + " " + String.valueOf(line2D.getP2()));
    }
}

import java.lang.String;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class LineClipper {

    public static void clipLineWithRectangle(Line2D line, Rectangle2D rect) {
        double x1 = line.getX1();
        double y1 = line.getY1();
        double x2 = line.getX2();
        double y2 = line.getY2();

        int outCode0 = computeOutCode(x1, y1, rect);
        int outCode1 = computeOutCode(x2, y2, rect);
        boolean accept = false;

        while (true) {
            if ((outCode0 | outCode1) == 0) { // BITWISE OR is 0: both points inside window; trivially accept and exit loop
                accept = true;
                break;
            } else if ((outCode0 & outCode1) != 0) { // BITWISE AND is not 0: both points share an outside zone (- bitwise AND finds common outside zone(s)).
                break;
            } else { // failed both tests, so calculate the line segment to clip
                double x = 0.0;
                double y = 0.0;

                int outCodeOut = (outCode1 != 0) ? outCode1 : outCode0;     // Now find intersection point;
                if ((outCodeOut & LineClipper.OUT_TOP) != 0) {           // intersection with top edge
                    x = x1 + (x2 - x1) * (rect.getMinY() - y1) / (y2 - y1);
                    y = rect.getMinY();
                } else if ((outCodeOut & LineClipper.OUT_BOTTOM) != 0) {   // intersection with bottom edge
                    x = x1 + (x2 - x1) * (rect.getMaxY() - y1) / (y2 - y1);
                    y = rect.getMaxY();
                } else if ((outCodeOut & LineClipper.OUT_LEFT) != 0) {   // intersection with left edge
                    y = y1 + (y2 - y1) * (rect.getMinX() - x1) / (x2 - x1);
                    x = rect.getMinX();
                } else if ((outCodeOut & LineClipper.OUT_RIGHT) != 0) {   // intersection with right edge
                    y = y1 + (y2 - y1) * (rect.getMaxX() - x1) / (x2 - x1);
                    x = rect.getMaxX();
                }
                if (outCodeOut == outCode0) {
                    x1 = x;
                    y1 = y;
                    outCode0 = computeOutCode(x1, y1, rect);
                } else {
                    x2 = x;
                    y2 = y;
                    outCode1 = computeOutCode(x2, y2, rect);
                }
            }
        }

        if (accept) {
            line.setLine(x1, y1, x2, y2);
        } else {
            line.setLine(0, 0, 0, 0);
        }
    }

    private static final int OUT_LEFT = 1;
    private static final int OUT_RIGHT = 2;
    private static final int OUT_BOTTOM = 4;
    private static final int OUT_TOP = 8;

    private static int computeOutCode(double x, double y, Rectangle2D rect) {
        int code;

        if (x < rect.getMinX())           // to the left of clip window
            code = OUT_LEFT;
        else if (x > rect.getMaxX())      // to the right of clip window
            code = OUT_RIGHT;
        else if (y < rect.getMinY())      // below the clip window
            code = OUT_BOTTOM;
        else if (y > rect.getMaxY())      // above the clip window
            code = OUT_TOP;
        else
            code = 0;                     // inside the clip window

        return code;
    }

    public static void main(String[] args) {
        Line2D line = new Line2D.Double(5, 30, 150, 70);
        Rectangle2D rect = new Rectangle2D.Double(10, 10, 50, 50);

        clipLineWithRectangle(line, rect);

        System.out.println("Clipped line: " + line);
    }
}
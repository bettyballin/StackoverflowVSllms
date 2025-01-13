/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_531 {
    static double atan2(Point point, Point point2) {
        return Math.atan2(point.y - point2.y, point.x - point2.x);
    }

    static void sortPoints(Point[] pointArray) {
        Point point = new Point(0.0, 0.0);
        for (Point point4 : pointArray) {
            point.x += point4.x;
            point.y += point4.y;
        }
        point.x /= (double)pointArray.length;
        point.y /= (double)pointArray.length;
        Arrays.sort(pointArray, (point2, point3) -> Double.compare(Main_531.atan2(point2, point), Main_531.atan2(point3, point)));
    }

    public static void main(String[] stringArray) {
        Point[] pointArray = new Point[]{new Point(1.0, 1.0), new Point(1.0, 3.0), new Point(3.0, 3.0), new Point(3.0, 1.0)};
        Main_531.sortPoints(pointArray);
        for (Point point : pointArray) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

    static class Point {
        double x;
        double y;

        Point(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }
}

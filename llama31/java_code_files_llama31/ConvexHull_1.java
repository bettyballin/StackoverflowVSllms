/*
 * Decompiled with CFR 0.152.
 */
public class ConvexHull_1 {
    public static boolean isConvex(Point[] pointArray) {
        int n;
        int n2 = pointArray.length;
        if (n2 < 3) {
            return true;
        }
        int n3 = 0;
        for (n = 1; n < n2; ++n) {
            if (pointArray[n].x >= pointArray[n3].x) continue;
            n3 = n;
        }
        n = n3;
        int n4 = 0;
        do {
            n4 = (n + 1) % n2;
            for (int i = 0; i < n2; ++i) {
                if (ConvexHull_1.orientation(pointArray[n], pointArray[i], pointArray[n4]) <= 0) continue;
                n4 = i;
            }
        } while ((n = n4) != n3);
        return true;
    }

    private static int orientation(Point point, Point point2, Point point3) {
        int n = (point2.y - point.y) * (point3.x - point2.x) - (point2.x - point.x) * (point3.y - point2.y);
        if (n == 0) {
            return 0;
        }
        return n > 0 ? 1 : 2;
    }

    public static void main(String[] stringArray) {
    }

    public static class Point {
        int x;
        int y;

        public Point(int n, int n2) {
            this.x = n;
            this.y = n2;
        }
    }
}

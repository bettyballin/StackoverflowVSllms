/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ConvexHull {
    public static List<Point> convexHull(List<Point> list) {
        Point point;
        int n = list.size();
        if (n < 3) {
            return list;
        }
        ArrayList<Point> arrayList = new ArrayList<Point>();
        Point point2 = list.get(0);
        for (int i = 1; i < n; ++i) {
            if (list.get((int)i).x >= point2.x) continue;
            point2 = list.get(i);
        }
        Point point3 = point2;
        do {
            arrayList.add(point3);
            point = null;
            for (Point point4 : list) {
                if (point4 == point3 || point != null && ConvexHull.orientation(point3, point, point4) >= 0) continue;
                point = point4;
            }
        } while ((point3 = point) != point2);
        return arrayList;
    }

    private static int orientation(Point point, Point point2, Point point3) {
        int n = (point2.y - point.y) * (point3.x - point2.x) - (point2.x - point.x) * (point3.y - point2.y);
        if (n == 0) {
            return 0;
        }
        return n > 0 ? 1 : -1;
    }

    public static void main(String[] stringArray) {
        ArrayList<Point> arrayList = new ArrayList<Point>();
        arrayList.add(new Point(0, 3));
        arrayList.add(new Point(1, 1));
        arrayList.add(new Point(2, 2));
        arrayList.add(new Point(4, 4));
        arrayList.add(new Point(0, 0));
        arrayList.add(new Point(1, 2));
        arrayList.add(new Point(3, 1));
        arrayList.add(new Point(3, 3));
        List<Point> list = ConvexHull.convexHull(arrayList);
        for (Point point : list) {
            System.out.println(point.x + " " + point.y);
        }
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int n, int n2) {
            this.x = n;
            this.y = n2;
        }
    }
}

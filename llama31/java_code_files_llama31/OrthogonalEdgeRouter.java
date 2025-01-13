/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class OrthogonalEdgeRouter {
    public static List<Point> routeEdge(Rectangle rectangle, Point point, Rectangle rectangle2, Point point2) {
        int n;
        ArrayList<Point> arrayList = new ArrayList<Point>();
        int n2 = Math.abs((int)(point2.x - point.x));
        int n3 = Math.abs(point2.y - point.y);
        int n4 = point2.x > point.x ? 1 : -1;
        int n5 = n = point2.y > point.y ? 1 : -1;
        if (n2 > n3) {
            arrayList.add(point);
            arrayList.add(new Point((int)(point.x + n2 * n4), point.y));
            arrayList.add(new Point((int)point2.x, point.y));
            arrayList.add(point2);
        } else {
            arrayList.add(point);
            arrayList.add(new Point((int)point.x, point.y + n3 * n));
            arrayList.add(new Point((int)point.x, point2.y));
            arrayList.add(point2);
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
    }
}

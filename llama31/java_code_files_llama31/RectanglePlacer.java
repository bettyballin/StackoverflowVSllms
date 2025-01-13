/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectanglePlacer {
    public static List<Rectangle> placeRectangles(int n, int n2, int n3) {
        ArrayList<Rectangle> arrayList = new ArrayList<Rectangle>();
        Random random = new Random();
        for (int i = 0; i < n3; ++i) {
            int n4;
            int n5;
            int n6;
            int n7;
            while (!RectanglePlacer.isValidRectangle(arrayList, n, n2, n7 = random.nextInt(n / 2) + 1, n6 = random.nextInt(n2 / 2) + 1)) {
            }
            while (RectanglePlacer.isOverlapping(arrayList, n5 = random.nextInt(n - n7), n4 = random.nextInt(n2 - n6), n7, n6)) {
            }
            arrayList.add(new Rectangle(n5, n4, n7, n6));
        }
        return arrayList;
    }

    private static boolean isValidRectangle(List<Rectangle> list, int n, int n2, int n3, int n4) {
        return n3 > 0 && n4 > 0 && n3 <= n && n4 <= n2;
    }

    private static boolean isOverlapping(List<Rectangle> list, int n, int n2, int n3, int n4) {
        for (Rectangle rectangle : list) {
            if (n >= rectangle.x + rectangle.width || n + n3 <= rectangle.x || n2 >= rectangle.y + rectangle.height || n2 + n4 <= rectangle.y) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        int n = 800;
        int n2 = 600;
        int n3 = 10;
        List<Rectangle> list = RectanglePlacer.placeRectangles(n, n2, n3);
        for (Rectangle rectangle : list) {
            System.out.println("x: " + rectangle.x + ", y: " + rectangle.y + ", width: " + rectangle.width + ", height: " + rectangle.height);
        }
    }

    private static class Rectangle {
        int x;
        int y;
        int width;
        int height;

        Rectangle(int n, int n2, int n3, int n4) {
            this.x = n;
            this.y = n2;
            this.width = n3;
            this.height = n4;
        }
    }
}

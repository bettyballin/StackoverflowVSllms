/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class MarchingSquares {
    private int[][] image;
    private int width;
    private int height;

    public MarchingSquares(int[][] nArray) {
        this.image = nArray;
        this.width = nArray.length;
        this.height = nArray[0].length;
    }

    public List<Point> getContour() {
        ArrayList<Point> arrayList = new ArrayList<Point>();
        for (int i = 0; i < this.height - 1; ++i) {
            for (int j = 0; j < this.width - 1; ++j) {
                int n = this.getSquareIndex(j, i);
                if (n == 0 || n == 15) continue;
                Point point = this.getPoint(j, i, n);
                Point point2 = this.getPoint(j + 1, i, n);
                arrayList.add(point);
                arrayList.add(point2);
            }
        }
        return arrayList;
    }

    private int getSquareIndex(int n, int n2) {
        int n3 = this.image[n][n2];
        int n4 = this.image[n + 1][n2];
        int n5 = this.image[n][n2 + 1];
        int n6 = this.image[n + 1][n2 + 1];
        return n3 << 3 | n4 << 2 | n5 << 1 | n6;
    }

    private Point getPoint(int n, int n2, int n3) {
        return new Point(n, n2);
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        MarchingSquares marchingSquares = new MarchingSquares(nArrayArray);
        List<Point> list = marchingSquares.getContour();
        for (Point point : list) {
            System.out.println("Point: (" + (int)point.x + ", " + point.y + ")");
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class CircleDrawer {
    private boolean[][] grid;

    public CircleDrawer(int n) {
        this.grid = new boolean[n][n];
    }

    public void drawCircle(int n, int n2, int n3) {
        int n4 = 3 - 2 * n3;
        int n5 = n3;
        for (int i = 0; i <= n5; ++i) {
            this.plot(n + i, n2 + n5);
            this.plot(n + i, n2 - n5);
            this.plot(n - i, n2 + n5);
            this.plot(n - i, n2 - n5);
            this.plot(n + n5, n2 + i);
            this.plot(n + n5, n2 - i);
            this.plot(n - n5, n2 + i);
            this.plot(n - n5, n2 - i);
            if (n4 < 0) {
                n4 += 4 * i + 6;
                continue;
            }
            n4 += 4 * (i - n5) + 10;
            --n5;
        }
    }

    public void plot(int n, int n2) {
        if (n >= 0 && n < this.grid.length && n2 >= 0 && n2 < this.grid[0].length) {
            this.grid[n][n2] = true;
        }
    }

    public static void main(String[] stringArray) {
        CircleDrawer circleDrawer = new CircleDrawer(100);
        circleDrawer.drawCircle(50, 50, 20);
    }
}

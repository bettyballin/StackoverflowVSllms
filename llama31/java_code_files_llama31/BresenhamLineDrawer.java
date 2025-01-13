/*
 * Decompiled with CFR 0.152.
 */
public class BresenhamLineDrawer {
    public void drawLine(int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n2 - n;
        int n7 = n4 - n3;
        if (Math.abs(n7) > Math.abs(n6)) {
            n5 = n;
            n = n3;
            n3 = n5;
            n5 = n2;
            n2 = n4;
            n4 = n5;
            n6 = n2 - n;
            n7 = n4 - n3;
        }
        n5 = 2 * n7 - n6;
        int n8 = 2 * n7;
        int n9 = 2 * (n7 - n6);
        int n10 = n3;
        for (int i = n; i <= n2; ++i) {
            if (n5 < 0) {
                n5 += n8;
            } else {
                n5 += n9;
                ++n10;
            }
            this.setPixel(i, n10);
        }
    }

    public void setPixel(int n, int n2) {
        System.out.println("Setting pixel at (" + n + ", " + n2 + ")");
    }

    public static void main(String[] stringArray) {
        BresenhamLineDrawer bresenhamLineDrawer = new BresenhamLineDrawer();
        bresenhamLineDrawer.drawLine(1, 10, 2, 8);
    }
}

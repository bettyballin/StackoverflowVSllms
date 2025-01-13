/*
 * Decompiled with CFR 0.152.
 */
public class ColorInterpolator {
    private static final int START_COLOR = 65280;
    private static final int END_COLOR = 0xFF0000;
    private static final int DURATION_HOURS = 240;

    public static int interpolateColor(int n) {
        int n2 = ColorInterpolator.interpolateComponent(255, 0, n);
        int n3 = ColorInterpolator.interpolateComponent(0, 255, n);
        int n4 = ColorInterpolator.interpolateComponent(0, 0, n);
        return n2 << 16 | n3 << 8 | n4;
    }

    private static int interpolateComponent(int n, int n2, int n3) {
        int n4 = n - n2;
        float f = (float)n3 / 240.0f;
        return n2 + (int)((float)n4 * f);
    }

    public static void main(String[] stringArray) {
        for (int i = 0; i <= 240; ++i) {
            int n = ColorInterpolator.interpolateColor(i);
            System.out.printf("%02X%02X%02X%n", n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF);
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class ColorDepthCalculator {
    public int calculateBitsPerPixel(int n, int n2) {
        return n * n2;
    }

    public static void main(String[] stringArray) {
        ColorDepthCalculator colorDepthCalculator = new ColorDepthCalculator();
        int n = 8;
        int n2 = 3;
        int n3 = colorDepthCalculator.calculateBitsPerPixel(n, n2);
        System.out.println("Bits per pixel: " + n3);
    }
}

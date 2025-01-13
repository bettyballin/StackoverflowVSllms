/*
 * Decompiled with CFR 0.152.
 */
public class RectangleAreaCalculator {
    public int calculateArea(int n, int n2) {
        if (n < 0 || n2 < 0) {
            throw new IllegalArgumentException("Width and height must be non-negative");
        }
        return n * n2;
    }

    public static void main(String[] stringArray) {
    }
}

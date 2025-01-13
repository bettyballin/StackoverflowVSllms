/*
 * Decompiled with CFR 0.152.
 */
public class BilinearInterpolation {
    public static int interpolate(int n, int n2, int n3, int n4) {
        int n5 = n < n3 / 2 ? n : n3 - n;
        int n6 = n2 < n4 / 2 ? n2 : n4 - n2;
        float f = (float)Math.min(n5, n6) / (float)(n3 / 2);
        int n7 = (int)(255.0f * f * f);
        return n7;
    }

    public static void main(String[] stringArray) {
    }
}

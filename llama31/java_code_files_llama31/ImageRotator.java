/*
 * Decompiled with CFR 0.152.
 */
public class ImageRotator {
    public static int[] rotateImage(int[] nArray, int n, int n2, int n3) {
        int[] nArray2 = new int[nArray.length];
        double d = Math.toRadians(n3);
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        int n4 = n / 2;
        int n5 = n2 / 2;
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n6 = i * n + j;
                int n7 = nArray[n6];
                int n8 = (int)((double)n4 + (double)(j - n4) * d2 - (double)(i - n5) * d3);
                int n9 = (int)((double)n5 + (double)(j - n4) * d3 + (double)(i - n5) * d2);
                if (n8 < 0 || n8 >= n || n9 < 0 || n9 >= n2) continue;
                int n10 = n9 * n + n8;
                nArray2[n10] = n7;
            }
        }
        return nArray2;
    }

    public static void main(String[] stringArray) {
    }
}

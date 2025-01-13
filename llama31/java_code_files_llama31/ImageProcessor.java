/*
 * Decompiled with CFR 0.152.
 */
public class ImageProcessor {
    public static void whiteBalance(int[] nArray) {
        int n5;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int n5 : nArray) {
            n2 += n5 >> 16 & 0xFF;
            n3 += n5 >> 8 & 0xFF;
            n4 += n5 & 0xFF;
        }
        int n6 = nArray.length;
        int n7 = n2 / n6;
        int n8 = n3 / n6;
        n5 = n4 / n6;
        int n9 = (n7 + n8 + n5) / 3;
        for (int i = 0; i < n6; ++i) {
            int n10 = nArray[i] >> 16 & 0xFF;
            int n11 = nArray[i] >> 8 & 0xFF;
            int n12 = nArray[i] & 0xFF;
            n10 = Math.min(255, (int)((double)n10 * (double)n9 / (double)n7));
            n11 = Math.min(255, (int)((double)n11 * (double)n9 / (double)n8));
            n12 = Math.min(255, (int)((double)n12 * (double)n9 / (double)n5));
            nArray[i] = n10 << 16 | n11 << 8 | n12;
        }
    }

    public static void main(String[] stringArray) {
    }
}

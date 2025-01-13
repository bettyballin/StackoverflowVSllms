/*
 * Decompiled with CFR 0.152.
 */
public class ColorGenerator {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{255, 0, 0};
        int n = 10;
        for (int i = 0; i <= n; ++i) {
            int[] nArray2 = ColorGenerator.interpolateColor(new int[]{255, 255, 255}, nArray, (double)i / (double)n);
            System.out.println(String.format("RGB(%d, %d, %d)", nArray2[0], nArray2[1], nArray2[2]));
        }
    }

    public static int[] interpolateColor(int[] nArray, int[] nArray2, double d) {
        int[] nArray3 = new int[3];
        for (int i = 0; i < 3; ++i) {
            nArray3[i] = (int)((double)nArray[i] + (double)(nArray2[i] - nArray[i]) * d);
        }
        return nArray3;
    }
}

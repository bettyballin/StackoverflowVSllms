/*
 * Decompiled with CFR 0.152.
 */
public class ArrayCutter {
    public static int cutArray(int[] nArray, int n, int n2, int n3) {
        if (n >= nArray.length) {
            return n2 == n3 ? nArray.length - 1 : -1;
        }
        int n4 = nArray[n];
        int n5 = ArrayCutter.cutArray(nArray, n + 1, n2 += n4, n3 -= n4);
        if (n5 != -1) {
            return n5;
        }
        return ArrayCutter.cutArray(nArray, n + 1, n2 -= n4, n3 += n4);
    }

    public static int cutArray(int[] nArray) {
        int n = 0;
        for (int i = 0; i < nArray.length; ++i) {
            n += nArray[i];
        }
        return ArrayCutter.cutArray(nArray, 0, 0, n);
    }

    public static void main(String[] stringArray) {
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class BubbleSort_1 {
    public static void sort(int[] nArray) {
        int n = nArray.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (nArray[j] <= nArray[j + 1]) continue;
                int n2 = nArray[j];
                nArray[j] = nArray[j + 1];
                nArray[j + 1] = n2;
            }
        }
    }

    public static void main(String[] stringArray) {
    }
}

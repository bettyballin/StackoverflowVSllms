/*
 * Decompiled with CFR 0.152.
 */
public class InsertionSort {
    public static void sort(int[] nArray) {
        for (int i = 1; i < nArray.length; ++i) {
            int n = nArray[i];
            for (int j = i - 1; j >= 0 && nArray[j] > n; --j) {
                nArray[j + 1] = nArray[j];
            }
            nArray[j + 1] = n;
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{5, 2, 8, 1, 9};
        InsertionSort.sort(nArray);
        for (int n : nArray) {
            System.out.print(n + " ");
        }
    }
}

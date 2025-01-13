/*
 * Decompiled with CFR 0.152.
 */
public class QuickSort_1 {
    public static void sort(int[] nArray) {
        QuickSort_1.quickSort(nArray, 0, nArray.length - 1);
    }

    private static void quickSort(int[] nArray, int n, int n2) {
        if (n < n2) {
            int n3 = QuickSort_1.partition(nArray, n, n2);
            QuickSort_1.quickSort(nArray, n, n3 - 1);
            QuickSort_1.quickSort(nArray, n3 + 1, n2);
        }
    }

    private static int partition(int[] nArray, int n, int n2) {
        int n3 = nArray[n2];
        int n4 = n - 1;
        for (int i = n; i < n2; ++i) {
            if (nArray[i] >= n3) continue;
            QuickSort_1.swap(nArray, ++n4, i);
        }
        QuickSort_1.swap(nArray, n4 + 1, n2);
        return n4 + 1;
    }

    private static void swap(int[] nArray, int n, int n2) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
    }

    public static void main(String[] stringArray) {
    }
}

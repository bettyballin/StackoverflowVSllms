/*
 * Decompiled with CFR 0.152.
 */
public class QuicksortAlgorithm {
    public static void quicksort(int[] nArray, int n, int n2) {
        if (n < n2) {
            int n3 = QuicksortAlgorithm.partition(nArray, n, n2);
            QuicksortAlgorithm.quicksort(nArray, n, n3 - 1);
            QuicksortAlgorithm.quicksort(nArray, n3 + 1, n2);
        }
    }

    private static int partition(int[] nArray, int n, int n2) {
        int n3 = nArray[n2];
        int n4 = n - 1;
        for (int i = n; i < n2; ++i) {
            if (nArray[i] >= n3) continue;
            QuicksortAlgorithm.swap(nArray, ++n4, i);
        }
        QuicksortAlgorithm.swap(nArray, n4 + 1, n2);
        return n4 + 1;
    }

    private static void swap(int[] nArray, int n, int n2) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{5, 2, 9, 1, 7, 3};
        QuicksortAlgorithm.quicksort(nArray, 0, nArray.length - 1);
        for (int n : nArray) {
            System.out.print(n + " ");
        }
    }
}

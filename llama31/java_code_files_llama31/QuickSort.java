/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

class QuickSort {
    QuickSort() {
    }

    public static void sort(int[] nArray) {
        QuickSort.quickSort(nArray, 0, nArray.length - 1);
    }

    private static void quickSort(int[] nArray, int n, int n2) {
        if (n < n2) {
            int n3 = QuickSort.partition(nArray, n, n2);
            QuickSort.quickSort(nArray, n, n3 - 1);
            QuickSort.quickSort(nArray, n3 + 1, n2);
        }
    }

    private static int partition(int[] nArray, int n, int n2) {
        int n3;
        int n4 = nArray[n2];
        int n5 = n - 1;
        for (n3 = n; n3 < n2; ++n3) {
            if (nArray[n3] > n4) continue;
            int n6 = nArray[++n5];
            nArray[n5] = nArray[n3];
            nArray[n3] = n6;
        }
        n3 = nArray[n5 + 1];
        nArray[n5 + 1] = nArray[n2];
        nArray[n2] = n3;
        return n5 + 1;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{5, 2, 8, 3, 1, 6, 4};
        QuickSort.sort(nArray);
        System.out.println(Arrays.toString(nArray));
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class QuickSort3Way {
    public static void sort(int[] nArray) {
        QuickSort3Way.sort(nArray, 0, nArray.length - 1);
    }

    private static void sort(int[] nArray, int n, int n2) {
        if (n >= n2) {
            return;
        }
        int n3 = nArray[n];
        int n4 = n + 1;
        int n5 = n2;
        int n6 = n + 1;
        while (n6 <= n5) {
            if (nArray[n6] < n3) {
                QuickSort3Way.swap(nArray, n6, n4);
                ++n4;
                ++n6;
                continue;
            }
            if (nArray[n6] > n3) {
                QuickSort3Way.swap(nArray, n6, n5);
                --n5;
                continue;
            }
            ++n6;
        }
        QuickSort3Way.swap(nArray, n, n4 - 1);
        QuickSort3Way.sort(nArray, n, n4 - 2);
        QuickSort3Way.sort(nArray, n5 + 1, n2);
    }

    private static void swap(int[] nArray, int n, int n2) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
    }

    public static void main(String[] stringArray) {
    }
}

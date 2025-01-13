/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Timsort {
    private static final int MIN_MERGE = 32;

    public static void sort(int[] nArray) {
        int n;
        int n2 = nArray.length;
        int n3 = Timsort.minRunLength(n2);
        for (n = 0; n < n2; n += n3) {
            Timsort.insertionSort(nArray, n, Math.min(n + n3 - 1, n2 - 1));
        }
        for (n = n3; n < n2; n *= 2) {
            for (int i = 0; i < n2; i += n * 2) {
                int n4 = i + n - 1;
                int n5 = Math.min(i + n * 2 - 1, n2 - 1);
                Timsort.merge(nArray, i, n4, n5);
            }
        }
    }

    private static int minRunLength(int n) {
        int n2 = 0;
        while (n >= 32) {
            n2 |= n & 1;
            n >>= 1;
        }
        return n + n2;
    }

    private static void insertionSort(int[] nArray, int n, int n2) {
        for (int i = n + 1; i <= n2; ++i) {
            int n3 = nArray[i];
            for (int j = i - 1; j >= n && nArray[j] > n3; --j) {
                nArray[j + 1] = nArray[j];
            }
            nArray[j + 1] = n3;
        }
    }

    private static void merge(int[] nArray, int n, int n2, int n3) {
        int[] nArray2 = Arrays.copyOfRange(nArray, n, n2 + 1);
        int[] nArray3 = Arrays.copyOfRange(nArray, n2 + 1, n3 + 1);
        int n4 = 0;
        int n5 = 0;
        int n6 = n;
        while (n4 < nArray2.length && n5 < nArray3.length) {
            if (nArray2[n4] <= nArray3[n5]) {
                nArray[n6] = nArray2[n4];
                ++n4;
            } else {
                nArray[n6] = nArray3[n5];
                ++n5;
            }
            ++n6;
        }
        while (n4 < nArray2.length) {
            nArray[n6] = nArray2[n4];
            ++n4;
            ++n6;
        }
        while (n5 < nArray3.length) {
            nArray[n6] = nArray3[n5];
            ++n5;
            ++n6;
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{4, 2, 9, 6, 23, 12, 34, 0, 1};
        Timsort.sort(nArray);
        System.out.println(Arrays.toString(nArray));
    }
}

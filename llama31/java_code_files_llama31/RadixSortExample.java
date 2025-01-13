/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class RadixSortExample {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{123, 456, 789, 12, 345, 678, 901};
        int n = nArray.length;
        RadixSortExample.radixSort(nArray, n);
        System.out.println(Arrays.toString(nArray));
    }

    public static void radixSort(int[] nArray, int n) {
        int n2 = RadixSortExample.getMax(nArray, n);
        int n3 = 1;
        while (n2 / n3 > 0) {
            RadixSortExample.countSort(nArray, n, n3);
            n3 *= 10;
        }
    }

    public static int getMax(int[] nArray, int n) {
        int n2 = nArray[0];
        for (int i = 1; i < n; ++i) {
            if (nArray[i] <= n2) continue;
            n2 = nArray[i];
        }
        return n2;
    }

    public static void countSort(int[] nArray, int n, int n2) {
        int n3;
        int[] nArray2 = new int[n];
        int[] nArray3 = new int[10];
        for (n3 = 0; n3 < n; ++n3) {
            int n4 = nArray[n3] / n2 % 10;
            nArray3[n4] = nArray3[n4] + 1;
        }
        for (n3 = 1; n3 < 10; ++n3) {
            int n5 = n3;
            nArray3[n5] = nArray3[n5] + nArray3[n3 - 1];
        }
        for (n3 = n - 1; n3 >= 0; --n3) {
            nArray2[nArray3[nArray[n3] / n2 % 10] - 1] = nArray[n3];
            int n6 = nArray[n3] / n2 % 10;
            nArray3[n6] = nArray3[n6] - 1;
        }
        for (n3 = 0; n3 < n; ++n3) {
            nArray[n3] = nArray2[n3];
        }
    }
}

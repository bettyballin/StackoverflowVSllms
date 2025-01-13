/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class RadixSorter {
    public static void radixSort(int[] nArray, int n) {
        int n2;
        int n3;
        int[] nArray2 = new int[n];
        int[] nArray3 = new int[n];
        for (n3 = 0; n3 < n; ++n3) {
            int n4 = n2 = nArray[n3] % n;
            nArray3[n4] = nArray3[n4] + 1;
        }
        for (n3 = 1; n3 < n; ++n3) {
            int n5 = n3;
            nArray3[n5] = nArray3[n5] + nArray3[n3 - 1];
        }
        for (n3 = n - 1; n3 >= 0; --n3) {
            n2 = nArray[n3] % n;
            nArray2[nArray3[n2] - 1] = nArray[n3];
            int n6 = n2;
            nArray3[n6] = nArray3[n6] - 1;
        }
        Arrays.fill(nArray3, 0);
        for (n3 = 0; n3 < n; ++n3) {
            int n7 = n2 = nArray[n3] / n % n;
            nArray3[n7] = nArray3[n7] + 1;
        }
        for (n3 = 1; n3 < n; ++n3) {
            int n8 = n3;
            nArray3[n8] = nArray3[n8] + nArray3[n3 - 1];
        }
        for (n3 = n - 1; n3 >= 0; --n3) {
            n2 = nArray[n3] / n % n;
            nArray2[nArray3[n2] - 1] = nArray[n3];
            int n9 = n2;
            nArray3[n9] = nArray3[n9] - 1;
        }
        Arrays.fill(nArray3, 0);
        for (n3 = 0; n3 < n; ++n3) {
            int n10 = n2 = nArray[n3] / (n * n);
            nArray3[n10] = nArray3[n10] + 1;
        }
        for (n3 = 1; n3 < n; ++n3) {
            int n11 = n3;
            nArray3[n11] = nArray3[n11] + nArray3[n3 - 1];
        }
        for (n3 = n - 1; n3 >= 0; --n3) {
            n2 = nArray[n3] / (n * n);
            nArray2[nArray3[n2] - 1] = nArray[n3];
            int n12 = n2;
            nArray3[n12] = nArray3[n12] - 1;
        }
        System.arraycopy(nArray2, 0, nArray, 0, n);
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int n = nArray.length;
        RadixSorter.radixSort(nArray, n);
        System.out.println(Arrays.toString(nArray));
    }
}

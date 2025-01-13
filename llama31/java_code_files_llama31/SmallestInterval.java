/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class SmallestInterval {
    public static void findSmallestInterval(int[] nArray, int n) {
        int n2;
        int n3;
        int n4 = nArray.length;
        int[] nArray2 = new int[n4];
        Arrays.sort(nArray);
        for (n3 = 0; n3 < n4; ++n3) {
            nArray2[n3] = (nArray[(n3 + 1) % n4] - nArray[n3] + n) % n;
        }
        n3 = 0;
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            if (nArray2[n2] <= n3) continue;
            n3 = nArray2[n2];
            n5 = n2;
        }
        n2 = (nArray[n5] + nArray[(n5 + 1) % n4] + n) / 2;
        int n6 = n3 / 2;
        System.out.println("Smallest interval: [" + (n2 - n6) + ", " + (n2 + n6) + "]");
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        int n = 10;
        SmallestInterval.findSmallestInterval(nArray, n);
    }
}

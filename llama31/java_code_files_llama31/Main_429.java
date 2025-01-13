/*
 * Decompiled with CFR 0.152.
 */
public class Main_429 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 5, 11, 2, 6, 8, 24, 101, 17, 8};
        int[] nArray2 = new int[]{5, 2, 11, 8, 17};
        int[] nArray3 = Main_429.findWindow(nArray, nArray2);
        System.out.println("i: " + nArray3[0] + ", j: " + nArray3[1]);
    }

    public static int[] findWindow(int[] nArray, int[] nArray2) {
        int n;
        int n2 = nArray2.length;
        int n3 = nArray.length;
        int[] nArray3 = new int[100000];
        int[] nArray4 = new int[n2];
        for (n = 0; n < nArray3.length; ++n) {
            nArray3[n] = -1;
        }
        for (n = 0; n < n2; ++n) {
            nArray3[nArray2[n]] = n;
        }
        n = Integer.MAX_VALUE;
        int n4 = -1;
        int n5 = -1;
        int n6 = 0;
        for (int i = 0; i < n3; ++i) {
            if (nArray3[nArray[i]] == -1) continue;
            if (nArray4[nArray3[nArray[i]]] == 0) {
                ++n6;
            }
            nArray4[nArray3[nArray[i]]] = i;
            if (n6 != n2) continue;
            int n7 = Integer.MAX_VALUE;
            int n8 = Integer.MIN_VALUE;
            for (int j = 0; j < n2; ++j) {
                n7 = Math.min(n7, nArray4[j]);
                n8 = Math.max(n8, nArray4[j]);
            }
            if (n8 - n7 + 1 >= n) continue;
            n = n8 - n7 + 1;
            n4 = n7;
            n5 = n8;
        }
        if (n4 == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{n4, n5};
    }
}

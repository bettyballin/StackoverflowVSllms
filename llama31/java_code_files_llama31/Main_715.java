/*
 * Decompiled with CFR 0.152.
 */
public class Main_715 {
    public static boolean isCyclicUtil(int n, boolean[] blArray, int[] nArray, int[][] nArray2) {
        blArray[n] = true;
        for (int i = 0; i < nArray2[n].length; ++i) {
            int n2 = nArray2[n][i];
            if (!blArray[n2]) {
                nArray[n2] = n;
                if (!Main_715.isCyclicUtil(n2, blArray, nArray, nArray2)) continue;
                return true;
            }
            if (nArray[n] == n2) continue;
            return true;
        }
        return false;
    }

    public static boolean isCyclic(int[][] nArray) {
        int n;
        boolean[] blArray = new boolean[nArray.length];
        int[] nArray2 = new int[nArray.length];
        for (n = 0; n < nArray.length; ++n) {
            blArray[n] = false;
            nArray2[n] = -1;
        }
        for (n = 0; n < nArray.length; ++n) {
            if (blArray[n] || !Main_715.isCyclicUtil(n, blArray, nArray2, nArray)) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{1, 2}, {0, 2, 3}, {0, 1, 3}, {1, 2}};
        System.out.println(Main_715.isCyclic(nArrayArray));
    }
}

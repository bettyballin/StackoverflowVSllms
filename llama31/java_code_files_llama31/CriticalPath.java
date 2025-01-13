/*
 * Decompiled with CFR 0.152.
 */
public class CriticalPath {
    public static int[] computeCriticalPath(int[][] nArray, int[] nArray2) {
        int n;
        int n2;
        int n3 = nArray.length;
        int[] nArray3 = new int[n3];
        int[] nArray4 = new int[n3];
        for (int i = 0; i < n3; ++i) {
            nArray3[i] = nArray2[i];
            nArray4[i] = -1;
        }
        int[] nArray5 = CriticalPath.topologicalSort(nArray);
        for (int i = 0; i < n3; ++i) {
            n2 = nArray5[i];
            for (n = 0; n < nArray[n2].length; ++n) {
                int n4 = nArray[n2][n];
                int n5 = nArray3[n2] + nArray2[n4];
                if (n5 <= nArray3[n4]) continue;
                nArray3[n4] = n5;
                nArray4[n4] = n2;
            }
        }
        int[] nArray6 = new int[n3];
        n2 = 0;
        n = n3 - 1;
        while (n >= 0) {
            nArray6[n2++] = n;
            n = nArray4[n];
        }
        return nArray6;
    }

    public static int[] topologicalSort(int[][] nArray) {
        int n = nArray.length;
        int[] nArray2 = new int[n];
        int[] nArray3 = new int[n];
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nArray2[i] != 0) continue;
            CriticalPath.dfs(nArray, i, nArray2, nArray3, n2);
        }
        return nArray3;
    }

    private static void dfs(int[][] nArray, int n, int[] nArray2, int[] nArray3, int n2) {
        nArray2[n] = 1;
        for (int i = 0; i < nArray[n].length; ++i) {
            int n3 = nArray[n][i];
            if (nArray2[n3] != 0) continue;
            CriticalPath.dfs(nArray, n3, nArray2, nArray3, n2);
        }
        nArray3[n2++] = n;
    }

    public static void main(String[] stringArray) {
    }
}

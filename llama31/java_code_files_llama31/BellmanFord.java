/*
 * Decompiled with CFR 0.152.
 */
public class BellmanFord {
    public static void bellmanFord(int[] nArray, int[] nArray2, int[][] nArray3) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5 = nArray.length;
        int n6 = nArray3.length;
        for (n4 = 0; n4 < n5; ++n4) {
            nArray[n4] = Integer.MAX_VALUE;
            nArray2[n4] = -1;
        }
        nArray[0] = 0;
        for (n4 = 0; n4 < n5 - 1; ++n4) {
            for (n3 = 0; n3 < n6; ++n3) {
                n2 = nArray3[n3][0];
                n = nArray3[n3][1];
                int n7 = nArray3[n3][2];
                if (nArray[n2] == Integer.MAX_VALUE || nArray[n2] + n7 >= nArray[n]) continue;
                nArray[n] = nArray[n2] + n7;
                nArray2[n] = n2;
            }
        }
        for (n4 = 0; n4 < n6; ++n4) {
            n3 = nArray3[n4][0];
            n2 = nArray3[n4][1];
            n = nArray3[n4][2];
            if (nArray[n3] == Integer.MAX_VALUE || nArray[n3] + n >= nArray[n2]) continue;
            System.out.println("Negative-weight cycle detected");
            return;
        }
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 1, 5}, {0, 2, 4}, {1, 2, 3}, {1, 3, 6}, {2, 3, 2}, {3, 4, 1}};
        int[] nArray = new int[5];
        int[] nArray2 = new int[5];
        BellmanFord.bellmanFord(nArray, nArray2, nArrayArray);
        System.out.println("Distances:");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Vertex " + i + ": " + nArray[i]);
        }
    }
}

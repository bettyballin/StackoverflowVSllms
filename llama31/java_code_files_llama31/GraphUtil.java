/*
 * Decompiled with CFR 0.152.
 */
public class GraphUtil {
    public static boolean[][] transitiveClosure(boolean[][] blArray) {
        int n;
        int n2;
        int n3 = blArray.length;
        boolean[][] blArray2 = new boolean[n3][n3];
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                blArray2[n2][n] = blArray[n2][n];
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                for (int i = 0; i < n3; ++i) {
                    boolean[] blArray3 = blArray2[n];
                    int n4 = i;
                    blArray3[n4] = blArray3[n4] | (blArray2[n][n2] && blArray2[n2][i]);
                }
            }
        }
        return blArray2;
    }

    public static void main(String[] stringArray) {
        boolean[][] blArrayArray = new boolean[][]{{true, false, false}, {false, true, false}, {false, false, true}};
        boolean[][] blArray = GraphUtil.transitiveClosure(blArrayArray);
        for (int i = 0; i < blArray.length; ++i) {
            for (int j = 0; j < blArray.length; ++j) {
                System.out.print(blArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class MazeRenderer {
    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 0}};
        for (int i = 0; i < nArrayArray.length; ++i) {
            for (int j = 0; j < nArrayArray[i].length; ++j) {
                if (nArrayArray[i][j] == 0) {
                    int n = 0;
                    for (int k = j; k < nArrayArray[i].length && nArrayArray[i][k] != 1; ++k) {
                        ++n;
                    }
                    System.out.print(".".repeat(n));
                    j += n - 1;
                    continue;
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}

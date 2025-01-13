/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class MinVertexCover {
    private int[] dp;
    private int[][] neighbours;

    public MinVertexCover(int[][] nArray) {
        this.neighbours = nArray;
        this.dp = new int[nArray.length];
        Arrays.fill(this.dp, -1);
    }

    public int getMinVertexCover(int n) {
        if (this.dp[n] != -1) {
            return this.dp[n];
        }
        int n2 = 0;
        if (this.neighbours[n].length == 0) {
            this.dp[n] = 0;
            return 0;
        }
        for (int n3 : this.neighbours[n]) {
            n2 += this.getMinVertexCover(n3);
        }
        int n4 = 1 + n2;
        int n5 = n2;
        this.dp[n] = Math.min(n4, n5);
        return this.dp[n];
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{1, 2}, {3}, {3}, new int[0]};
        MinVertexCover minVertexCover = new MinVertexCover(nArrayArray);
        System.out.println("Minimum Vertex Cover: " + minVertexCover.getMinVertexCover(0));
    }
}

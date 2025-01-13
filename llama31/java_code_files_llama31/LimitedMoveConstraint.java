/*
 * Decompiled with CFR 0.152.
 */
public class LimitedMoveConstraint {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] array;
    private boolean[][] visited;
    private int startX;
    private int startY;
    private int maxMoves;

    public LimitedMoveConstraint(int[][] nArray, int n, int n2, int n3) {
        this.array = nArray;
        this.startX = n;
        this.startY = n2;
        this.maxMoves = n3;
        this.visited = new boolean[nArray.length][nArray[0].length];
    }

    public void traverse() {
        this.dfs(this.startX, this.startY, 0);
    }

    private void dfs(int n, int n2, int n3) {
        if (n3 > this.maxMoves) {
            return;
        }
        this.visited[n][n2] = true;
        for (int[] nArray : DIRECTIONS) {
            int n4 = n + nArray[0];
            int n5 = n2 + nArray[1];
            if (!this.isValid(n4, n5) || this.visited[n4][n5]) continue;
            this.dfs(n4, n5, n3 + 1);
        }
        this.visited[n][n2] = false;
    }

    private boolean isValid(int n, int n2) {
        return n >= 0 && n < this.array.length && n2 >= 0 && n2 < this.array[0].length;
    }

    public static void main(String[] stringArray) {
    }
}

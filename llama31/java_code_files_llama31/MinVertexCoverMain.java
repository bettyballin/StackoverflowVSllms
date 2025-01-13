/*
 * Decompiled with CFR 0.152.
 */
public class MinVertexCoverMain {
    public static void main(String[] stringArray) {
        MinVertexCoverMain minVertexCoverMain = new MinVertexCoverMain();
        minVertexCoverMain.run();
    }

    public void run() {
        int[][] nArrayArray = new int[][]{{1, 2}, {0, 3}, {0, 4}, {1}, {2}};
        MinVertexCover minVertexCover = new MinVertexCover(nArrayArray);
        int n = minVertexCover.getMinVertexCover(0);
        System.out.println("Minimum vertex cover: " + n);
    }
}

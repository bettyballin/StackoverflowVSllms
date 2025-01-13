/*
 * Decompiled with CFR 0.152.
 */
public class CycleDetector {
    public static void main(String[] stringArray) {
        UnionFind unionFind = new UnionFind(3);
        int[][] nArrayArray = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        if (unionFind.hasCycle(nArrayArray)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class SpanThing {
    private SegmentTree[] trees;

    public SpanThing(int[][] nArray) {
        this.trees = new SegmentTree[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            this.trees[i] = new SegmentTree(nArray[i]);
        }
    }

    public int[] MinsSmart(int n, int n2) {
        int[] nArray = new int[this.trees.length];
        for (int i = 0; i < this.trees.length; ++i) {
            nArray[i] = this.trees[i].query(n, n2);
        }
        return nArray;
    }

    public static void main(String[] stringArray) {
        int[] nArray;
        int[][] nArrayArray = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        SpanThing spanThing = new SpanThing(nArrayArray);
        for (int n : nArray = spanThing.MinsSmart(1, 3)) {
            System.out.println(n);
        }
    }
}

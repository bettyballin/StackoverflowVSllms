/*
 * Decompiled with CFR 0.152.
 */
public class SegmentTreeExample {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(nArray);
        System.out.println(segmentTree.query(1, 4));
        segmentTree.update(3, 10);
        System.out.println(segmentTree.query(1, 4));
    }
}

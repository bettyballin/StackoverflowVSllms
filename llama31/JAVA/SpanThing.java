import java.lang.String;

class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] data) {
        n = data.length;
        tree = new int[4 * n];
        buildTree(data, 0, 0, n - 1);
    }

    private void buildTree(int[] data, int treeIndex, int start, int end) {
        if (start == end) {
            tree[treeIndex] = data[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(data, 2 * treeIndex + 1, start, mid);
            buildTree(data, 2 * treeIndex + 2, mid + 1, end);
            tree[treeIndex] = Math.min(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }
    }

    public int query(int from, int to) {
        return query(0, 0, n - 1, from, to);
    }

    private int query(int treeIndex, int start, int end, int from, int to) {
        if (from > end || to < start) {
            return Integer.MAX_VALUE;
        }
        if (from <= start && to >= end) {
            return tree[treeIndex];
        }
        int mid = (start + end) / 2;
        return Math.min(query(2 * treeIndex + 1, start, mid, from, to),
                query(2 * treeIndex + 2, mid + 1, end, from, to));
    }
}

public class SpanThing {
    private SegmentTree[] trees;

    public SpanThing(int[][] data) {
        trees = new SegmentTree[data.length];
        for (int i = 0; i < data.length; i++) {
            trees[i] = new SegmentTree(data[i]);
        }
    }

    public int[] MinsSmart(int from, int to) {
        int[] result = new int[trees.length];
        for (int i = 0; i < trees.length; i++) {
            result[i] = trees[i].query(from, to);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] data = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        SpanThing spanThing = new SpanThing(data);
        int[] mins = spanThing.MinsSmart(1, 3);
        for (int min : mins) {
            System.out.println(min);
        }
    }
}
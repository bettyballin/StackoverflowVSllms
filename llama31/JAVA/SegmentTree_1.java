import java.lang.Integer;
import java.lang.String;

public class SegmentTree_1_1 {
    private int[] tree;
    private int n;

    public SegmentTree_1(int[] data) {
        n = data.length;
        tree = new int[4 * n];
        buildTree(data, 0, 0, n - 1);
    }

    private void buildTree(int[] data, int node, int start, int end) {
        if (start == end) {
            tree[node] = data[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(data, 2 * node + 1, start, mid);
            buildTree(data, 2 * node + 2, mid + 1, end);
            tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public int query(int from, int to) {
        return query(0, 0, n - 1, from, to);
    }

    private int query(int node, int start, int end, int from, int to) {
        if (from > end || to < start) {
            return Integer.MAX_VALUE;
        }
        if (from <= start && end <= to) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(query(2 * node + 1, start, mid, from, to),
                query(2 * node + 2, mid + 1, end, from, to));
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        SegmentTree_1 segmentTree = new SegmentTree_1(data);
        System.out.println(segmentTree.query(1, 3));  // Output: 2
    }
}
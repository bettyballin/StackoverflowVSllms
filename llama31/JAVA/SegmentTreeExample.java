import java.lang.String;

class SegmentTree {
    int[] tree;
    int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, tree, 0, n - 1, 0);
    }

    public void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
        if (start == end) {
            tree[treeNode] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(arr, tree, start, mid, 2 * treeNode + 1);
        buildTree(arr, tree, mid + 1, end, 2 * treeNode + 2);

        tree[treeNode] = tree[2 * treeNode + 1] + tree[2 * treeNode + 2];
    }

    public int query(int queryStart, int queryEnd) {
        return queryHelper(0, arr.length - 1, queryStart, queryEnd, 0);
    }

    private int queryHelper(int start, int end, int queryStart, int queryEnd, int treeNode) {
        if (queryStart > end || queryEnd < start) {
            return 0;
        }

        if (queryStart <= start && queryEnd >= end) {
            return tree[treeNode];
        }

        int mid = (start + end) / 2;
        int leftSum = queryHelper(start, mid, queryStart, queryEnd, 2 * treeNode + 1);
        int rightSum = queryHelper(mid + 1, end, queryStart, queryEnd, 2 * treeNode + 2);

        return leftSum + rightSum;
    }

    public void update(int index, int value) {
        int diff = value - arr[index];
        arr[index] = value;
        updateHelper(0, arr.length - 1, index, diff, 0);
    }

    private void updateHelper(int start, int end, int index, int diff, int treeNode) {
        if (index < start || index > end) {
            return;
        }

        tree[treeNode] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            updateHelper(start, mid, index, diff, 2 * treeNode + 1);
            updateHelper(mid + 1, end, index, diff, 2 * treeNode + 2);
        }
    }
}

public class SegmentTreeExample {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);
        
        System.out.println(segmentTree.query(1, 4)); // Output: 24
        
        segmentTree.update(3, 10);
        
        System.out.println(segmentTree.query(1, 4)); // Output: 27
    }
}
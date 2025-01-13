import java.lang.String;
public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }

    private void buildTree(int[] arr, int treeIndex, int start, int end) {
        if (start == end) {
            tree[treeIndex] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(arr, 2 * treeIndex + 1, start, mid);
            buildTree(arr, 2 * treeIndex + 2, mid + 1, end);
            tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
        }
    }

    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int treeIndex, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[treeIndex];
        }
        int mid = (start + end) / 2;
        return query(2 * treeIndex + 1, start, mid, left, right)
                + query(2 * treeIndex + 2, mid + 1, end, left, right);
    }

    public void update(int index, int value) {
        update(0, 0, n - 1, index, value);
    }

    private void update(int treeIndex, int start, int end, int index, int value) {
        if (start == end) {
            tree[treeIndex] = value;
        } else {
            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                update(2 * treeIndex + 1, start, mid, index, value);
            } else {
                update(2 * treeIndex + 2, mid + 1, end, index, value);
            }
            tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
        }
    }

	public static void main(String[] args) {
	}
}
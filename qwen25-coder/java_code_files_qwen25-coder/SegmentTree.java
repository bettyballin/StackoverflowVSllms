import java.lang.String;
public class SegmentTree {
    private int[] st; // array to store segment tree nodes
    private int n;  // size of input arr

    public SegmentTree(int[] arr) {
        n = arr.length;
        st = new int[getSegmentTreeSize(n)];
        build(arr);
    }

    private int getSegmentTreeSize(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        return 2 * (1 << height) - 1;
    }

    // Build segment tree from input array
    private void build(int[] arr) {
        build(arr, 0, n - 1, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se]
    private int build(int[] arr, int ss, int se, int i) {
        if (ss == se) { // If there is one element in array, store it in current node of segment tree and return
            st[i] = arr[ss];
            return arr[ss];
        }

        int mid = getMid(ss, se);
        st[i] = build(arr, ss, mid, 2 * i + 1) + build(arr, mid + 1, se, 2 * i + 2);
        return st[i];
    }

    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    // Return sum of elements in range from index qs to qe. It mainly uses getSumUtil()
    public int getSum(int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            throw new IllegalArgumentException("Invalid Query");
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    // A recursive function to get the sum of values in given range of array
    private int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) { // If segment of this node is a part of given range
            return st[si];
        }
        if (se < qs || ss > qe) { // If segment of this node is outside the given range
            return 0;
        }

        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
               getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    // A recursive function to update the nodes which have the given index in their range
    public void updateValue(int arr[], int i, int newValue) {
        if (i < 0 || i > n - 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int diff = newValue - arr[i];
        arr[i] = newValue;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    private void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se) {
            return;
        }
        st[si] = st[si] + diff; // add the difference to current node
        if (se != ss) { // if not a leaf node then recur for children
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println("Sum of values in given range = " +
                           segmentTree.getSum(1, 3));

        // Update: set arr[1] = 10 and update corresponding segment tree nodes.
        segmentTree.updateValue(arr, 1, 10);
    
        System.out.println("Updated sum of values in given range = " +
                           segmentTree.getSum(1, 3));
    }
}
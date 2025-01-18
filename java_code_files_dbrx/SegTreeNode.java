import java.util.Vector;

public class SegTreeNode {
    int start, end, median;
    SegTreeNode left, right;

    Vector<SegTreeNode> search(int start, int end) {
        // start, the starting point of query and 'end' its endpoint.
        if (this.start >= start && this.end <= end) {
            // current tree is completely within the query interval, returns itself and all its descendants.
            Vector<SegTreeNode> result = new Vector<>();
            result.add(this);
            // Add all descendants (implementation depends on tree structure).
            /*...*/
            return result;
        } else {
            // current range falls in partially or not at all into given query: search accordingly.
            Vector<SegTreeNode> l = new Vector<>(), r = new Vector<>();
            if (start < this.median && this.left != null) {
                // if start point of the range is before midpoint, continue left subtree.
                l = this.left.search(start, end);
            } 
            if (end > this.median && this.right != null) {
                // if end point of the range is after midpoint, continue right subtree.
                r = this.right.search(start, end);
            }
            return mergeResultVectors(l, r); // merges both result Vectors and returns as the result of our query in this case.
        }
    }

    Vector<SegTreeNode> mergeResultVectors(Vector<SegTreeNode> l, Vector<SegTreeNode> r) {
        Vector<SegTreeNode> result = new Vector<>();
        if (l != null) result.addAll(l);
        if (r != null) result.addAll(r);
        return result;
    }
}
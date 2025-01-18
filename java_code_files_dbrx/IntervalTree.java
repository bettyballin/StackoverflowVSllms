class IntervalTree {
    // Class Node to represent a range along with max endpoint in left and right Subtrees.
    class Node implements Comparable<Node> {
        long p, s, e; // point (or segment), start, end points of current interval.
        int maxE;
        Node left, right;

        public int compareTo(Node o) {
            // Compare points first to make a valid binary search tree.
            if (this.p != o.p)
                return Long.compare(this.p, o.p);
            else
                return Integer.compare(this.maxE, o.maxE);
        } // if points are same, compare endpoints to maintain heap property i.e.,
          // parent's endpoint is always <= than its immediate children's endpoint.

        Node() {
            // node constructor here...
        }
    } // class Definition of NODE ends.
}
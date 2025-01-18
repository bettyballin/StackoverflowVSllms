import java.lang.String;

public class SegmentTreeBuilder {

    private class Node {
        Node left;
        Node right;
    }

    Node makeSegTree(int start, int end) {
        if (start > end) return null;
        Node current = new Node();
        int mid = start + (end-start)/2; //avoiding overflow in case of large intervals.
        current.left  = makeSegTree(start, mid);         //call recursively for left subtree.
        current.right = makeSegTree(mid+1, end);         //and then right subtree...
        return current;
    } //ends function definition for make Segment tree from input intervals.

    public static void main(String[] args) {
    }

}
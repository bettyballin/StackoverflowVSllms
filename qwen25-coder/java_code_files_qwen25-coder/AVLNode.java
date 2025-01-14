class AVLNode {
    int key;
    int height; // Height of node
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 0; // Initial height for a new node is 0 (a leaf node)
        left = null;
        right = null;
    }
}

public class AVLTree {
    // Function to calculate the height of the tree
    int height(AVLNode N) {
        if (N == null)
            return -1; // An empty node has a height of -1
        return N.height;
    }

    public static void main(String[] args) {
    }
}
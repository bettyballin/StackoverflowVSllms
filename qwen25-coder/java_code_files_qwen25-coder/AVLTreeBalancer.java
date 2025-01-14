public class AVLTreeBalancer {

    // AVL Node class
    class AVLNode {
        int key, height;
        AVLNode left, right;

        AVLNode(int key) {
            this.key = key;
            height = 1;
        }
    }

    // Function to get the height of the tree
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Get Balance factor of node N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    AVLNode insert(AVLNode node, int key) {
        // Perform the normal BST insertion
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // If node is unbalanced, then try the 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rotateRight(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        // Return the node pointer
        return node;
    }

    public static void main(String[] args) {
        // Main method can be used to test the AVLTreeBalancer
    }
}
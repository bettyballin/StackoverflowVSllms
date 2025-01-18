import java.lang.String;

public class BinaryTreePrinter {

    Node root;

    // Node class
    class Node {
        int data;
        Node left, right;
    }

    int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lheight = height(node.left);
            int rheight = height(node.right);
            return Math.max(lheight, rheight) + 1;
        }
    }

    public void printLevelOrder() {
        int h = height(root);
        for (int i = 1; i <= h; ++i) {
            System.out.println("Elements at level " + i + ":");
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    void printGivenLevel(Node root, int level) {
        if (root == null || level < 1)
            return;
        if (level == 1)
            System.out.print(" " + root.data);
        else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
    }
}
import java.lang.String;
import java.lang.Integer;
import java.util.*;

public class Node_1 {

    class IndexTree {
        private class Node {
            int value;
            Node left, right;
            int size; // number of descendants

            Node(int v) {
                value = v;
                size = 1;
            }
        }

        private Node root;

        int getElementAtIndex(int index) {
            return getElementAtIndex(root, index);
        }

        private int getElementAtIndex(Node node, int index) {
            if (node == null) throw new NoSuchElementException("Index out of bounds");

            int leftSize = size(node.left);
            if (leftSize < index && index <= leftSize + 1) return node.value;
            else if (index <= leftSize)
                return getElementAtIndex(node.left, index - 1);
            else
                return getElementAtIndex(node.right, index - leftSize - 1);
        }

        void insert(int value) {
            root = insert(root, value);
        }

        private Node insert(Node node, int value) {
            if (node == null) return new Node(value);

            if (value < node.value)
                node.left = insert(node.left, value);
            else
                node.right = insert(node.right, value);

            updateSize(node);
            return balance(node);
        }

        void delete(int value) {
            root = delete(root, value);
        }

        private Node delete(Node node, int value) {
            if (node == null) throw new NoSuchElementException("Value not found");

            int cmp = Integer.compare(value, node.value);
            if (cmp < 0)
                node.left = delete(node.left, value);
            else if (cmp > 0)
                node.right = delete(node.right, value);
            else {
                Node leftNode = node.left;
                Node rightNode = node.right;

                if (leftNode == null || rightNode == null) return leftNode != null ? leftNode : rightNode;

                Node minOfRight = getMin(rightNode);
                minOfRight.right = removeMin(rightNode);
                minOfRight.left = leftNode;
                node = balance(minOfRight);
            }

            updateSize(node);
            return balance(node);
        }

        private void updateSize(Node n) {
            n.size = 1 + size(n.left) + size(n.right);
        }

        private Node getMin(Node n) {
            while (n != null && n.left != null)
                n = n.left;

            return n;
        }

        private Node removeMin(Node n) {
            if (n == null || n.left == null) return n.right;

            n.left = removeMin(n.left);

            updateSize(n);
            return balance(n);
        }

        private int size(Node node) {
            return node != null ? node.size : 0;
        }

        private Node balance(Node node) {
            // Placeholder for balancing logic (AVL or Red-Black rotation logic)
            return node;
        }
    }

    public static void main(String[] args) {
        Node_1 example = new Node_1();
        IndexTree tree = example.new IndexTree();
        // Example usage:
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);

        try {
            System.out.println("Element at index 3: " + tree.getElementAtIndex(3));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        tree.delete(3);

        try {
            System.out.println("Element at index 2 after deletion: " + tree.getElementAtIndex(2));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
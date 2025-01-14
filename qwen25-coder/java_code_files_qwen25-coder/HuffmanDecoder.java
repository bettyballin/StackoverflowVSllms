import java.util.List;

public class HuffmanDecoder {

    public static String decode(Node root, List<Integer> encodedBits) {
        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;

        for (Integer bit : encodedBits) {
            if (bit == 0 && currentNode.left != null) {
                currentNode = currentNode.left;
            } else if (currentNode.right != null) {
                currentNode = currentNode.right;
            }

            // If a leaf node, add the symbol to the decoded string
            if (isLeaf(currentNode)) {
                decodedString.append(currentNode.symbol);
                currentNode = root; // Reset to search from the start of the tree again
            }
        }

        return decodedString.toString();
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
    }

    // Definition of Node class
    static class Node {
        Node left;
        Node right;
        char symbol;

        // Constructor for leaf nodes
        public Node(char symbol) {
            this.symbol = symbol;
        }

        // Constructor for internal nodes
        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }
}
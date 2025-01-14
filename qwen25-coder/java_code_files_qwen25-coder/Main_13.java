import java.util.List;
import java.util.ArrayList;

public class Main_13 {
    public static void main(String[] args) {
        // Example usage:
        Node root = new Node('*', 0); // Dummy root node
        // Insert nodes into the tree here based on your Huffman codes

        List<Integer> encodedBits = new ArrayList<>();
        // Convert "101010001110001001100001010101110111000101010110" to a list of bits
        String binaryData = "101010001110001001100001010101110111000101010110";
        for (char c : binaryData.toCharArray()) {
            encodedBits.add(c - '0');
        }

        String decodedMessage = HuffmanDecoder.decode(root, encodedBits);
        System.out.println("Decoded message: " + decodedMessage);
    }
}

class Node {
    char symbol;
    int frequency;
    Node left;
    Node right;

    public Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }
}

class HuffmanDecoder {
    public static String decode(Node root, List<Integer> encodedBits) {
        StringBuilder decoded = new StringBuilder();
        Node current = root;
        for (int bit : encodedBits) {
            if (bit == 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decoded.append(current.symbol);
                current = root;
            }
        }
        return decoded.toString();
    }
}
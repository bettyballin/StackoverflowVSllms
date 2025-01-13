import java.util.List;
import java.util.ArrayList;

public class BKTree {
    private Node root;

    public BKTree(int[] keys) {
        root = buildTree(keys);
    }

    private Node buildTree(int[] keys) {
        // Create the root node with the first key
        Node root = new Node(keys[0]);

        // Add remaining keys to the tree
        for (int i = 1; i < keys.length; i++) {
            addKey(root, keys[i]);
        }

        return root;
    }

    private void addKey(Node node, int key) {
        // Calculate the Hamming distance between the key and the node's key
        int distance = hammingDistance(node.key, key);

        // If the distance is 0, we've found a duplicate key, so return
        if (distance == 0) return;

        // Create a new node with the key and add it to the tree
        Node child = new Node(key);
        node.children.add(child);

        // Update the node's distance to its children
        node.distance = Math.max(node.distance, distance);
    }

    public List<Integer> search(int queryKey, int maxDistance) {
        List<Integer> results = new ArrayList<>();

        searchRecursive(root, queryKey, maxDistance, results);

        return results;
    }

    private void searchRecursive(Node node, int queryKey, int maxDistance, List<Integer> results) {
        // Calculate the Hamming distance between the query key and the node's key
        int distance = hammingDistance(node.key, queryKey);

        // If the distance is within the allowed range, add the node's key to the results
        if (distance <= maxDistance) {
            results.add(node.key);
        }

        // Prune branches that are guaranteed to have a Hamming distance greater than the desired threshold
        if (node.distance > maxDistance) return;

        // Recursively search child nodes
        for (Node child : node.children) {
            searchRecursive(child, queryKey, maxDistance, results);
        }
    }

    private int hammingDistance(int a, int b) {
        // Calculate the Hamming distance between two integers
        int distance = 0;
        for (int i = 0; i < 64; i++) {
            if ((a & (1L << i)) != (b & (1L << i))) {
                distance++;
            }
        }
        return distance;
    }

    private static class Node {
        int key;
        int distance;
        List<Node> children = new ArrayList<>();

        Node(int key) {
            this.key = key;
        }
    }

	public static void main(String[] args) {
		BKTree tree = new BKTree(new int[] {1, 2, 3, 4, 5});
		System.out.println(tree.search(3, 2));
	}
}
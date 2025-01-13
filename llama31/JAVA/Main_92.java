import java.util.*;

class BKTree {
    private Node root;

    public BKTree(int[] keys) {
        root = new Node(keys[0]);
        for (int i = 1; i < keys.length; i++) {
            insert(keys[i]);
        }
    }

    private void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        int distance = editDistance(node.key, key);
        if (distance > 0) {
            if (node.children[distance] == null) {
                node.children[distance] = new Node(key);
            } else {
                node.children[distance] = insertRecursive(node.children[distance], key);
            }
        }

        return node;
    }

    public List<int[]> search(int queryKey, int maxDistance) {
        List<int[]> results = new ArrayList<>();
        searchRecursive(root, queryKey, maxDistance, results);
        return results;
    }

    private void searchRecursive(Node node, int queryKey, int maxDistance, List<int[]> results) {
        if (node == null) {
            return;
        }

        int distance = editDistance(node.key, queryKey);
        if (distance <= maxDistance) {
            results.add(new int[] { node.key, distance });
        }

        int minDistance = Math.max(1, distance - maxDistance);
        int maxDist = Math.min(node.children.length - 1, distance + maxDistance);

        for (int i = minDistance; i <= maxDist; i++) {
            searchRecursive(node.children[i], queryKey, maxDistance, results);
        }
    }

    private int editDistance(int a, int b) {
        // Simplified edit distance calculation for demonstration purposes
        // In a real implementation, you would use a more sophisticated algorithm like Levenshtein distance
        return Math.abs(a - b);
    }

    private static class Node {
        int key;
        Node[] children;

        public Node(int key) {
            this.key = key;
            this.children = new Node[10]; // Adjust the size based on your needs
        }
    }
}

public class Main_92 {
    public static void main(String[] args) {
        int[] keys = { 10, 20, 30, 40, 50 };
        BKTree tree = new BKTree(keys);

        int queryKey = 35;
        int maxDistance = 6;

        List<int[]> results = tree.search(queryKey, maxDistance);
        for (int[] result : results) {
            System.out.println("Key: " + result[0] + ", Distance: " + result[1]);
        }
    }
}
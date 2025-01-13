import java.lang.String;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public int shortestPath(Node root) {
        // This method is not implemented, you need to implement the logic to find the shortest path
        return 0;
    }
}

public class BinaryTreeSolution {
    public static void main(String[] args) {
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        binaryTreeSolution.run();
    }

    public void run() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution solution = new Solution();
        int shortestPathLength = solution.shortestPath(root);
        System.out.println("Shortest path length: " + shortestPathLength);
    }
}
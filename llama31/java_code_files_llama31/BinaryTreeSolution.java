/*
 * Decompiled with CFR 0.152.
 */
public class BinaryTreeSolution {
    public static void main(String[] stringArray) {
        BinaryTreeSolution binaryTreeSolution = new BinaryTreeSolution();
        binaryTreeSolution.run();
    }

    public void run() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        Solution solution = new Solution();
        int n = solution.shortestPath(node);
        System.out.println("Shortest path length: " + n);
    }
}

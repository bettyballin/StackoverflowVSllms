/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;

public class BinaryTreeTraversal {
    public void iterativeTraversal(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> linkedList = new LinkedList<Node>();
        linkedList.add(node);
        while (!linkedList.isEmpty()) {
            Node node2 = (Node)linkedList.poll();
            System.out.print(node2.value + " ");
            if (node2.left != null) {
                linkedList.add(node2.left);
            }
            if (node2.right == null) continue;
            linkedList.add(node2.right);
        }
    }

    public void recursiveTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        this.recursiveTraversal(node.left);
        this.recursiveTraversal(node.right);
    }

    public static void main(String[] stringArray) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        System.out.println("Iterative Traversal:");
        binaryTreeTraversal.iterativeTraversal(node);
        System.out.println("\nRecursive Traversal:");
        binaryTreeTraversal.recursiveTraversal(node);
    }
}

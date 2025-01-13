/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

public class TreeTraversal {
    public static void traverse(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node node2 = (Node)stack.pop();
            System.out.println(node2.value);
            if (node2.right != null) {
                stack.push(node2.right);
            }
            if (node2.left == null) continue;
            stack.push(node2.left);
        }
    }

    public static void main(String[] stringArray) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        TreeTraversal.traverse(node);
    }
}

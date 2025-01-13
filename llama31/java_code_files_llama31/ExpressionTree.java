/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

public class ExpressionTree {
    private Node root;

    public void parsePostfixExpression(String string) {
        String[] stringArray;
        Stack<Node> stack = new Stack<Node>();
        for (String string2 : stringArray = string.split("\\s+")) {
            Node node;
            if (this.isOperator(string2)) {
                node = (Node)stack.pop();
                Node node2 = (Node)stack.pop();
                Node node3 = new Node(string2);
                node3.left = node2;
                node3.right = node;
                stack.push(node3);
                continue;
            }
            node = new Node(string2);
            stack.push(node);
        }
        this.root = (Node)stack.pop();
    }

    private boolean isOperator(String string) {
        return string.equals("^") || string.equals("*") || string.equals("+") || string.equals("-") || string.equals("/");
    }

    public void printInorder() {
        this.printInorder(this.root);
    }

    private void printInorder(Node node) {
        if (node != null) {
            this.printInorder(node.left);
            System.out.print(node.value + " ");
            this.printInorder(node.right);
        }
    }

    public static void main(String[] stringArray) {
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.parsePostfixExpression("A 2 ^ 2 A * B * - B 2 ^ + A B - /");
        expressionTree.printInorder();
    }

    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String string) {
            this.value = string;
        }
    }
}

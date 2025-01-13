import java.lang.String;
import java.util.Stack;

public class ExpressionTree {
    private Node root;

    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public void parsePostfixExpression(String expression) {
        Stack<Node> stack = new Stack<>();

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                Node rightChild = stack.pop();
                Node leftChild = stack.pop();
                Node internalNode = new Node(token);
                internalNode.left = leftChild;
                internalNode.right = rightChild;
                stack.push(internalNode);
            } else {
                Node leafNode = new Node(token);
                stack.push(leafNode);
            }
        }

        root = stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("^") || token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/");
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }
    }

    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.parsePostfixExpression("A 2 ^ 2 A * B * - B 2 ^ + A B - /");
        expressionTree.printInorder();
    }
}
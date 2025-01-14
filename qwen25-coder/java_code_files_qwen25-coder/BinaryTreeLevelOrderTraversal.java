import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<>();

    public void levelOrder(Node root) {
        if (root == null) return;
        traverse(root, 0);
    }

    private void traverse(Node node, int level) {
        if (levels.size() <= level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.value);

        if (node.left != null) traverse(node.left, level + 1);
        if (node.right != null) traverse(node.right, level + 1);
    }

    public void printLevels() {
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        tree.levelOrder(root);
        tree.printLevels();
    }
}
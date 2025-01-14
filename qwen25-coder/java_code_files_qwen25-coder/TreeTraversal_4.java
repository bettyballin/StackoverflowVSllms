import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int id;
    List<TreeNode> parents;
    List<TreeNode> children;

    public TreeNode(int id) {
        this.id = id;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
        child.parents.add(this);
    }
}

public class TreeTraversal_4 {

    // Traverses the tree downwards from the given node
    public static void traverseDownward(TreeNode node, List<Integer> path) {
        if (node == null) return;
        path.add(node.id);
        for (TreeNode child : node.children) {
            traverseDownward(child, new ArrayList<>(path));
        }
        // Print or collect full path only when reaching a leaf
        if (node.children.isEmpty()) {
            System.out.println(path);
        }
    }

    // Traverses the tree upwards from the given node
    public static void traverseUpward(TreeNode node, List<Integer> path) {
        if (node == null) return;
        path.add(node.id);
        for (TreeNode parent : node.parents) {
            traverseUpward(parent, new ArrayList<>(path));
        }
        // Print or collect full path only when reaching a root
        if (node.parents.isEmpty()) {
            System.out.println(path);
        }
    }

    public static void main(String[] args) {
        // Example tree construction
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);

        // Traverse downward from node 1
        System.out.println("Downward traversals:");
        traverseDownward(node1, new ArrayList<>());

        // Traverse upward from node 4
        System.out.println("\nUpward traversals:");
        traverseUpward(node4, new ArrayList<>());
    }
}
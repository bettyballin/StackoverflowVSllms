import java.util.HashMap;
import java.util.Map;

class TreeNode {
    String id;
    Map<String, TreeNode> children;

    public TreeNode(String id) {
        this.id = id;
        this.children = new HashMap<>();
    }

    public void addChild(TreeNode child) {
        this.children.put(child.id, child);
    }
}

public class TreeMerger {

    // Recursive method to merge two tree nodes
    private static void mergeNodes(TreeNode nodeA, TreeNode nodeB) {
        if (nodeB == null) return;

        // Merge children of `nodeB` into `nodeA`
        for (Map.Entry<String, TreeNode> entry : nodeB.children.entrySet()) {
            String childId = entry.getKey();
            TreeNode childNodeB = entry.getValue();

            // If `nodeA` does not have this child, add it
            if (!nodeA.children.containsKey(childId)) {
                nodeA.addChild(new TreeNode(childNodeB.id));
            }

            // Recursively merge nodes with the same ID
            mergeNodes(nodeA.children.get(childId), childNodeB);
        }
    }

    public static void main(String[] args) {
        // Constructing treeA
        TreeNode treeA = new TreeNode("root");
        TreeNode childA_A = new TreeNode("a");
        TreeNode childB_A = new TreeNode("b");

        childA_A.addChild(new TreeNode("abc"));
        childB_A.addChild(new TreeNode("xyz"));

        treeA.addChild(childA_A);
        treeA.addChild(childB_A);

        // Constructing treeB
        TreeNode treeB = new TreeNode("root");
        TreeNode childA_B = new TreeNode("a");
        TreeNode childB_B = new TreeNode("b");
        TreeNode childC_B = new TreeNode("c");

        childA_B.addChild(new TreeNode("qrs"));
        childB_B.addChild(new TreeNode("xyz"));
        childB_B.children.get("xyz").addChild(new TreeNode("pdq"));
        childC_B.addChild(new TreeNode("pdq"));

        treeB.addChild(childA_B);
        treeB.addChild(childB_B);
        treeB.addChild(childC_B);

        // Merge treeB into treeA
        mergeNodes(treeA, treeB);

        // Print merged tree (simple DFS for demonstration)
        printTree(treeA, "");
    }

    private static void printTree(TreeNode node, String prefix) {
        if (node == null) return;
        System.out.println(prefix + node.id);
        for (TreeNode child : node.children.values()) {
            printTree(child, prefix + "  ");
        }
    }
}
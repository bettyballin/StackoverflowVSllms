import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class class_4_4 {
    // Define a simple TreeNode class
    static class TreeNode {
        String value;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(String value) {
            this.value = value;
        }

        // Method to add a child node
        public void addChild(TreeNode node) {
            children.add(node);
        }
    }

    // Method to merge two trees
    public static TreeNode mergeTrees(TreeNode treeA, TreeNode treeB) {
        if (treeA == null) return treeB;
        if (treeB == null) return treeA;

        // Merge the current level
        List<TreeNode> mergedChildren = mergeChildren(treeA.children, treeB.children);

        // Create a new merged node or reuse an existing one
        TreeNode mergedNode = new TreeNode(treeA.value); // Assuming values are the same for simplicity
        mergedNode.children = mergedChildren;

        return mergedNode;
    }

    // Helper method to merge the children of two nodes
    private static List<TreeNode> mergeChildren(List<TreeNode> childrenA, List<TreeNode> childrenB) {
        List<TreeNode> mergedChildren = new ArrayList<>();
        Map<String, TreeNode> childrenFromB = new HashMap<>();

        // Prepare children from TreeB for efficient lookup
        for (TreeNode childB : childrenB) {
            childrenFromB.put(childB.value, childB);
        }

        // Iterate through children of TreeA and merge as necessary
        for (TreeNode childA : childrenA) {
            if (childrenFromB.containsKey(childA.value)) {
                // Recursively merge children with the same value
                TreeNode mergedChild = mergeTrees(childA, childrenFromB.get(childA.value));
                mergedChildren.add(mergedChild);
                childrenFromB.remove(childA.value); // To avoid duplicates
            } else {
                mergedChildren.add(childA); // No match, add as is
            }
        }

        // Add any remaining children from TreeB that weren't merged
        for (TreeNode remainingChild : childrenFromB.values()) {
            mergedChildren.add(remainingChild);
        }

        return mergedChildren;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode treeA = new TreeNode("A");
        treeA.addChild(new TreeNode("B"));
        treeA.addChild(new TreeNode("C"));

        TreeNode treeB = new TreeNode("A");
        treeB.addChild(new TreeNode("B"));
        treeB.addChild(new TreeNode("D"));

        TreeNode mergedTree = mergeTrees(treeA, treeB);
    }
}
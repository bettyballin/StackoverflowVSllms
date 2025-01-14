public class BinaryTree {

    public static class TreeNode {
        char data;
        TreeNode left, right;

        public TreeNode(char item) {
            data = item;
            left = right = null;
        }
    }

    // Serialize the tree into a string representation
    private String serialize(TreeNode node) {
        if (node == null) {
            return "L";  // Use 'L' to denote null nodes as leaves for unique serialization
        }

        // Pre-order traversal for serialization
        return "#" + node.data + serialize(node.left) + serialize(node.right);
    }

    // Check if t2Str is a substring of t1Str
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        String t1 = serialize(T1);
        String t2 = serialize(T2);

        return t1.contains(t2);
    }

    public static void main(String[] args) {
        // Test code can be added here
    }
}
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    private String id;
    private List<TreeNode> children;
    private List<TreeNode> parents;

    public String getId() {
        return id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public List<TreeNode> getParents() {
        return parents;
    }

    // Constructor and other methods for TreeNode class
    public TreeNode(String id) {
        this.id = id;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void addParent(TreeNode parent) {
        parents.add(parent);
    }
}

public class TreeNodeTraverser {
    public void traverseDown(TreeNode node, List<String> visited) {
        visited.add(node.getId());
        for (TreeNode child : node.getChildren()) {
            traverseDown(child, visited);
        }
    }

    public void traverseUp(TreeNode node, List<String> visited) {
        visited.add(node.getId());
        for (TreeNode parent : node.getParents()) {
            traverseUp(parent, visited);
        }
    }

    public List<List<String>> getAllLinks(TreeNode node) {
        List<List<String>> links = new ArrayList<>();
        List<String> visited = new ArrayList<>();

        // Downward traversal
        traverseDown(node, visited);
        links.add(new ArrayList<>(visited));
        visited.clear();

        // Upward traversal
        traverseUp(node, visited);
        links.add(new ArrayList<>(visited));

        return links;
    }

    public static void main(String[] args) {
        TreeNodeTraverser traverser = new TreeNodeTraverser();

        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");

        nodeA.addChild(nodeB);
        nodeB.addChild(nodeC);
        nodeC.addChild(nodeD);

        nodeD.addParent(nodeC);
        nodeC.addParent(nodeB);
        nodeB.addParent(nodeA);

        List<List<String>> links = traverser.getAllLinks(nodeB);

        for (List<String> link : links) {
            System.out.println(link);
        }
    }
}
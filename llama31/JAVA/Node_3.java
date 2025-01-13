import java.util.List;
import java.util.ArrayList;

public class Node_3 {
    String value;
    List<Node> children;

    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public boolean containsSubtree(Node subtree) {
        if (value.equals(subtree.value)) {
            if (children.size() == subtree.children.size()) {
                for (int i = 0; i < children.size(); i++) {
                    if (!children.get(i).containsSubtree(subtree.children.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        for (Node child : children) {
            if (child.containsSubtree(subtree)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        Node child1 = new Node("B");
        Node child2 = new Node("C");
        root.addChild(child1);
        root.addChild(child2);

        Node subtree = new Node("B");
        System.out.println(root.containsSubtree(subtree));  // prints: true
    }
}
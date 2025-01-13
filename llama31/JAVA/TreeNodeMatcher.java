import java.lang.String;

class Node {
    String value;
    Node[] children;

    public Node(String value) {
        this.value = value;
        this.children = new Node[0];
    }

    public void addChild(Node child) {
        Node[] newChildren = new Node[children.length + 1];
        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[children.length] = child;
        children = newChildren;
    }

    public boolean containsSubtree(Node subtree) {
        if (this.value.equals(subtree.value)) {
            if (this.children.length == subtree.children.length) {
                boolean match = true;
                for (int i = 0; i < this.children.length; i++) {
                    match &= this.children[i].containsSubtree(subtree.children[i]);
                }
                if (match) {
                    return true;
                }
            }
        }
        for (Node child : this.children) {
            if (child.containsSubtree(subtree)) {
                return true;
            }
        }
        return false;
    }
}

public class TreeNodeMatcher {
    public static void main(String[] args) {
        Node tree = new Node("A");
        tree.addChild(new Node("B"));
        tree.addChild(new Node("A"));
        tree.addChild(new Node("A"));

        Node subtree = new Node("A");
        subtree.addChild(new Node("A"));
        subtree.addChild(new Node("A"));

        if (tree.containsSubtree(subtree)) {
            System.out.println("Tree contains subtree");
        } else {
            System.out.println("Tree does not contain subtree");
        }
    }
}
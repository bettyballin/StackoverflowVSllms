public class NodeVisitor {

    public void visitNode(Node node) {
        if (node.getId() != null) {
            node.getId().apply(this);
        }
    }

    public static void main(String[] args) {
        NodeVisitor visitor = new NodeVisitor();
        Node node = new Node();
        visitor.visitNode(node);
    }
}

class Node {
    public Id getId() {
        return new Id();
    }
}

class Id {
    public void apply(NodeVisitor visitor) {
        // Implement the functionality here
    }
}
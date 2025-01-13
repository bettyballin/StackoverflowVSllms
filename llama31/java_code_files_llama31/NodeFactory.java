/*
 * Decompiled with CFR 0.152.
 */
public class NodeFactory {
    public static Node createNode(NodeType nodeType) {
        Node node = new Node(nodeType);
        View view = NodeFactory.createView(node);
        Controller controller = NodeFactory.createController(node);
        return node;
    }

    private static View createView(Node node) {
        return new View(node);
    }

    private static Controller createController(Node node) {
        return new Controller(node);
    }

    public static void main(String[] stringArray) {
        Node node = NodeFactory.createNode(NodeType.TYPE1);
        System.out.println((Object)node.getType());
    }
}

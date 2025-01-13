/*
 * Decompiled with CFR 0.152.
 */
public class TreeNodeMatcher {
    public static void main(String[] stringArray) {
        Node node = new Node("A");
        node.addChild(new Node("B"));
        node.addChild(new Node("A"));
        node.addChild(new Node("A"));
        Node node2 = new Node("A");
        node2.addChild(new Node("A"));
        node2.addChild(new Node("A"));
        if (node.containsSubtree(node2)) {
            System.out.println("Tree contains subtree");
        } else {
            System.out.println("Tree does not contain subtree");
        }
    }
}

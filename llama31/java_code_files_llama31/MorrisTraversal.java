/*
 * Decompiled with CFR 0.152.
 */
class MorrisTraversal {
    MorrisTraversal() {
    }

    public static void traverse(Node node) {
        while (node != null) {
            if (node.left == null) {
                System.out.print(node.data + " ");
                node = node.right;
                continue;
            }
            Node node2 = node.left;
            while (node2.right != null && node2.right != node) {
                node2 = node2.right;
            }
            if (node2.right == null) {
                node2.right = node;
                node = node.left;
                continue;
            }
            node2.right = null;
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] stringArray) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        MorrisTraversal.traverse(node);
    }
}

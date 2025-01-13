/*
 * Decompiled with CFR 0.152.
 */
public class BinaryTreeToList {
    public static void flatten(Node node) {
        if (node == null) {
            return;
        }
        BinaryTreeToList.flatten(node.left);
        BinaryTreeToList.flatten(node.right);
        if (node.left != null) {
            Node node2 = node.left;
            while (node2.right != null) {
                node2 = node2.right;
            }
            node2.right = node.right;
            node.right = node.left;
            node.left = null;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] stringArray) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        BinaryTreeToList.flatten(node);
        BinaryTreeToList.printList(node);
    }
}

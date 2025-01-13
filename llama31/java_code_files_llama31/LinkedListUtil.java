/*
 * Decompiled with CFR 0.152.
 */
public class LinkedListUtil {
    public void deleteNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to delete cannot be null or last node in the list");
        }
        Node node2 = node.next;
        node.data = node2.data;
        node.next = node2.next;
    }

    public static void main(String[] stringArray) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        linkedListUtil.deleteNode(node.next);
    }
}

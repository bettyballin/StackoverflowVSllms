/*
 * Decompiled with CFR 0.152.
 */
public class CircularLinkedList {
    Node head;

    void insert(Node node) {
        if (this.head == null) {
            node.next = this.head = node;
        } else {
            Node node2 = this.head;
            while (node2.next != this.head) {
                node2 = node2.next;
            }
            node.next = node2.next;
            node2.next = node;
            int n = node2.data;
            node2.data = node.data;
            node.data = n;
            this.head = node;
        }
    }

    public static void main(String[] stringArray) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        circularLinkedList.insert(node);
        circularLinkedList.insert(node2);
        circularLinkedList.insert(node3);
    }
}

/*
 * Decompiled with CFR 0.152.
 */
public class LinkedList_2 {
    public static boolean isCircular(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node node2 = node;
        Node node3 = node;
        while (node3 != null && node3.next != null) {
            node2 = node2.next;
            node3 = node3.next.next;
            if (node2 != node3) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(LinkedList_2.isCircular(node));
        node4.next = null;
        System.out.println(LinkedList_2.isCircular(node));
    }

    static class Node {
        int data;
        Node next;

        public Node(int n) {
            this.data = n;
        }
    }
}

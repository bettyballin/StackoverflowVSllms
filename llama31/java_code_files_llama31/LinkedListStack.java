/*
 * Decompiled with CFR 0.152.
 */
public class LinkedListStack {
    private Node head;

    public void push(int n) {
        Node node = new Node(n);
        node.next = this.head;
        this.head = node;
    }

    public int pop() {
        if (this.head == null) {
            throw new RuntimeException("Stack is empty");
        }
        int n = this.head.value;
        this.head = this.head.next;
        return n;
    }

    public static void main(String[] stringArray) {
    }

    private static class Node {
        int value;
        Node next;

        public Node(int n) {
            this.value = n;
        }
    }
}

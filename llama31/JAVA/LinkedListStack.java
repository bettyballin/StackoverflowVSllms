import java.lang.String;
public class LinkedListStack {
    private Node head;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new RuntimeException("Stack is empty");
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

	public static void main(String[] args) {
	}
}
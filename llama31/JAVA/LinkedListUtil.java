// Define the Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListUtil {
    public void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            throw new IllegalArgumentException("Node to delete cannot be null or last node in the list");
        }

        Node nextNode = nodeToDelete.next;
        nodeToDelete.data = nextNode.data;
        nodeToDelete.next = nextNode.next;
    }

    public static void main(String[] args) {
        LinkedListUtil util = new LinkedListUtil();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        util.deleteNode(head.next); // Delete node with value 2
    }
}
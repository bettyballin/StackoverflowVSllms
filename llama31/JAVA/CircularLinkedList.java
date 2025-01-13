import java.lang.String;

// Define Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head; // Declare head variable

    void insert(Node newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) { // Traverse to the last node
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            // Swap data of newNode and temp (last node)
            int tempData = temp.data;
            temp.data = newNode.data;
            newNode.data = tempData;
            head = newNode;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        circularLinkedList.insert(node1);
        circularLinkedList.insert(node2);
        circularLinkedList.insert(node3);
    }
}
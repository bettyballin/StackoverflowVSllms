import java.lang.String;
class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;

    public void insert(Node N) {
        if (head == null) { // linked list is empty
            head = N;
            N.next = head; // circular link to itself
        } else {
            N.next = head.next;
            head.next = N;
            // This inserts the new node right after the head
        }
    }

    public void printList() {
        Node current = head;
        if (head != null) {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        clist.insert(node1);
        System.out.println("After inserting 1:");
        clist.printList();

        clist.insert(node2);
        System.out.println("\nAfter inserting 2:");
        clist.printList();
    }
}
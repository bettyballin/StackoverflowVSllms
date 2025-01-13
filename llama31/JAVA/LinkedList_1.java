import java.util.List;

// Define a Node class to represent each element in the linked list
class Node {
    Object info;
    Node prev;
    Node next;

    public Node(Object info) {
        this.info = info;
        this.prev = null;
        this.next = null;
    }

    public Object info() {
        return info;
    }

    public boolean isFirst() {
        return prev == null;
    }

    public boolean isLast() {
        return next == null;
    }

    public Node next() {
        return next;
    }

    public Node prev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void killNext() {
        next = null;
    }

    public void killPrev() {
        prev = null;
    }
}

// Define a LinkedList class with the delete method
public class LinkedList_1_1 {
    private Node head;

    public LinkedList_1() {
        head = null;
    }

    public Node first() {
        return head;
    }

    public LinkedList_1 delete(Object o) {
        if (head == null)
            return this;

        Node ref = head;

        while (true) {
            if (ref.info.equals(o)) {
                if (ref.isFirst() && ref.isLast()) {
                    head = null;
                    break;
                } else if (ref.isFirst()) {
                    head = ref.next();
                    ref.killPrev();
                    ref = head;
                    break;
                } else if (ref.isLast()) {
                    ref.prev().killNext(); // Update the next reference of the new last node
                    ref = ref.prev();
                    break;
                } else {
                    ref.prev().setNext(ref.next());
                    ref.next().setPrev(ref.prev());
                    ref = ref.prev();
                    break;
                }
            } else {
                if (!ref.isLast())
                    ref = ref.next();
                else
                    break;
            }
        }
        return this;
    }

    public static void main(String[] args) {
    }
}
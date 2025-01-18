import java.lang.String;
public class LinkedListTraversalUtils {
    public void printLinkedListBackwards(Node head) {
        Node current = head;
        int size = 0;

        // First pass to find the size of the list.
        while (current != null) {
            current = current.next;
            size++;
        }

        // Second pass to print the list backwards based on its size.
        for (int i = 1; i <= size; i++) {
            System.out.println(getNthFromLast(head, i).data);
        }
    }

    public Node getNthFromLast(Node head, int n) {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref_ptr == null) {
                    // n is greater than the number of nodes in the list
                    return null;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            return main_ptr;
        }
        return null;
    }

    public static void main(String[] args) {
    }

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
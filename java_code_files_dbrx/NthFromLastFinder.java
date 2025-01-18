import java.lang.String;
public class NthFromLastFinder {
    public Node getNthFromLast(Node head, int n) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < n - 1; i++) {
            if (p2 == null) return null; // out of bounds index
            else p2 = p2.next;
        }

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1; // nth element from last in original linked list
    }

    public static void main(String[] args) {
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
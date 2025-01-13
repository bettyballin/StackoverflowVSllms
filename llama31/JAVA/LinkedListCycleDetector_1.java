// Define the Node class
class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

public class LinkedListCycleDetector_1_1 {
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycleDetector_1 detector = new LinkedListCycleDetector_1();
        
        // Example usage:
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create a cycle

        System.out.println(detector.hasCycle(node1)); // Should print: true
    }
}
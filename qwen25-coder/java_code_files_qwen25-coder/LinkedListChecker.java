import java.lang.String;
class ListNode {
    int value;
    ListNode next;

    ListNode(int x) {
        value = x;
        next = null;
    }
}

public class LinkedListChecker {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps

            if (slow == fast) {        // Cycle detected
                return true;
            }
        }

        return false;                  // No cycle
    }

    public static void main(String[] args) {
        LinkedListChecker checker = new LinkedListChecker();

        // Example usage:
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // Uncomment the line below to create a cycle for testing
        // node4.next = node2;

        boolean isCircular = checker.hasCycle(node1);
        System.out.println("Is the linked list circular? " + isCircular);
    }
}
import java.lang.String;

// Define the ListNode class
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// Define the Solution class
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public ListNode findStartOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

public class LinkedListCycleDetector {
    public static void main(String[] args) {
        // Create a linked list with a cycle for demonstration
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node71 = new ListNode(71);
        ListNode node45 = new ListNode(45);
        ListNode node7 = new ListNode(7);

        node1.next = node3;
        node3.next = node5;
        node5.next = node71;
        node71.next = node45;
        node45.next = node7;
        node7.next = node5; // Create the cycle

        Solution solution = new Solution();

        // Check if there's a cycle
        boolean hasCycle = solution.hasCycle(node1);
        System.out.println("Linked list has a cycle: " + hasCycle);

        // Find the start of the cycle
        ListNode startOfCycle = solution.findStartOfCycle(node1);
        if (startOfCycle != null) {
            System.out.println("Start of the cycle: " + startOfCycle.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
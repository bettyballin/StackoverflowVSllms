import java.lang.String;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Found a cycle
            }
        }

        return false; // No cycle
    }

    // Function to find the start of the cycle if it exists
    public ListNode findStartOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean cycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break; // Found a cycle, prepare to find its start
            }
        }

        if (!cycle) return null; // No cycle

        // Reset slow to the head and keep fast at the meeting point
        slow = head;

        // Move both one step at a time to find the start of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Return the start of the cycle
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create a cycle

        Solution solution = new Solution();
        System.out.println("Has cycle: " + solution.hasCycle(node1)); // Should print true
        System.out.println("Start of cycle: " + solution.findStartOfCycle(node1).val); // Should print 2
    }
}
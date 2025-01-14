import java.lang.String;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleDetector {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by 1 step
            fast = fast.next.next;     // Move fast by 2 steps

            if (slow == fast) {        // Check for cycle
                return true;
            }
        }

        return false;                  // No cycle found
    }

	public static void main(String[] args) {
	}
}
import java.lang.String;
public class LinkedListCycleDetector_1 {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {
            value = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps

            if (slow == fast) {        // They meet, there's a cycle
                return true;
            }
        }

        return false;                  // No cycle found
    }

	public static void main(String[] args) {
	}
}
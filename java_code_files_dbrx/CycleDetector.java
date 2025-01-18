public class CycleDetector {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // If there is no cycle, eventually fast will become null
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next; // The critical move: moving faster!
        }

        return true;
    }

    public static void main(String[] args) {
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
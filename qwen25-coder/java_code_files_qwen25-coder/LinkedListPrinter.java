import java.lang.String;
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

public class LinkedListPrinter {

    public void printListBackwards(ListNode head) {
        if (head == null) return;

        // Reverse the list pointers temporarily
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;
        
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Print the reversed list
        current = prev;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

        // Restore the original list by reversing pointers again
        ListNode restorePrev = null;
        current = prev;
        
        while (current != null) {
            nextNode = current.next;
            current.next = restorePrev;
            restorePrev = current;
            current = nextNode;
        }
    }

	public static void main(String[] args) {
	}
}
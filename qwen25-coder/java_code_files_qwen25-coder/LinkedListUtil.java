import java.lang.String;
class ListNode {
    int value;
    ListNode next;

    // Constructor
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListUtil {
    public static void deleteNode(ListNode node) {
        // Ensure it's not the last node
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Cannot delete the last node with this method.");
        }

        // Copy data from the next node to the current node
        node.value = node.next.value;
        // Bypass the next node
        node.next = node.next.next;
    }

	public static void main(String[] args) {
	}
}
import java.lang.String;

class Node {
    int data;
    Node next;
}

public class Solution {

    public boolean hasCycle(Node head) {
       if(head == null || head.next == null){
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            // If there is no cycle, then we will definitely reach the end of our list here
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            // Use "fast.next.next" to make faster pointer move twice as fast as slow pointer
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
    }
}
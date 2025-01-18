import java.lang.String;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class HereisaclassnamefortheprovidedJavacodeLinkedListCycleDetector {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
          }
         ListNode slow = head;
         ListNode fast = head.next;
         while(slow != fast){
             //If there is no loop then the "fast" will eventually become null
             if (fast==null || fast.next == null) { return false;}
                else{
                    slow = slow.next;
                    fast = fast.next.next;
                 }
         }
            //if they meet at any point then a loop exists
           return true;
    }
	public static void main(String[] args) {
	}
}
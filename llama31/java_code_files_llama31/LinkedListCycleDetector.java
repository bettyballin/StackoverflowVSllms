/*
 * Decompiled with CFR 0.152.
 */
public class LinkedListCycleDetector {
    public static void main(String[] stringArray) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(71);
        ListNode listNode5 = new ListNode(45);
        ListNode listNode6 = new ListNode(7);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode3;
        Solution solution = new Solution();
        boolean bl = solution.hasCycle(listNode);
        System.out.println("Linked list has a cycle: " + bl);
        ListNode listNode7 = solution.findStartOfCycle(listNode);
        if (listNode7 != null) {
            System.out.println("Start of the cycle: " + listNode7.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}

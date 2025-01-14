public class LinkedListNode {

    public Object info;
    public LinkedListNode next;
    public LinkedListNode prev;

    public boolean isFirst() {
        return prev == null;
    }

    public boolean isLast() {
        return next == null;
    }

    public Object info() {
        return info;
    }

    public LinkedListNode delete(Object o) {
        if (info == null)
            return this;

        LinkedListNode ref = this;
        while (ref != null) {
            if (ref.info() == o) {
                if (ref.isFirst()) {
                    if (ref.isLast()) {
                        return null; // If it's both first and last, the list becomes empty
                    }
                    ref.next.prev = null; // Set previous of the new head to null
                    return ref.next; // Return the new head
                } else if (ref.isLast()) {
                    ref.prev.next = null; // Set next of the new tail to null
                } else {
                    ref.prev.next = ref.next;
                    ref.next.prev = ref.prev; // Skip the current node
                }
            }
            ref = ref.next; // Move to the next element
        }
        return this; // Return the modified list
    }

    public static void main(String[] args) {
    }
}
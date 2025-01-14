public class LinkedListNode_1 {
    // Fields
    Object info;
    LinkedListNode_1 next;
    LinkedListNode_1 prev;

    // Constructor
    public LinkedListNode_1(Object info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    // Methods
    public Object info() {
        return info;
    }

    public boolean isFirst() {
        return (prev == null);
    }

    public boolean isLast() {
        return (next == null);
    }

    public LinkedListNode_1 delete(Object o) {
        if (info == null)
            return this;

        LinkedListNode_1 ref = this;
        while (true) {
            boolean found = false;
            if ((ref.info() == null && o != null || ref.info() != null && !ref.info().equals(o)) && ref.next != null) {
                ref = ref.next; // Move to the next element
            } else if ((ref.info() == null && o == null) || (ref.info() != null && ref.info().equals(o))) {
                found = true;
                if (ref.isFirst()) {
                    if (ref.isLast()) {
                        return null; // If it's both first and last, the list becomes empty
                    }
                    ref = ref.next;
                    ref.prev = null; // Set previous of the new head to null
                } else if (ref.isLast()) {
                    ref = ref.prev;
                    ref.next = null; // Set next of the new tail to null
                } else {
                    ref.prev.next = ref.next;
                    ref.next.prev = ref.prev; // Skip the current node
                }
            }
            // found = false; // This line is unnecessary and might be causing confusion

            if (found || ref.isLast())
                break; // Exit loop if an element was found or we reach the end
        }

        return this; // Return the modified list
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}
public class CircularBuffer {
    private Object[] buffer; // fixed size array
    private int start, end;  // indices for adding/removing elements

    public void add(Object element) {
        if (isFull()) removeOldest();   // removes oldest element to make space when full
        writeAtEnd(element);            // adds new element at the end of buffer
    }
    
    private boolean isFull() {
        // dummy implementation to make the code compile
        return false;
    }

    private void removeOldest() {
        // dummy implementation to make the code compile
    }

    private void writeAtEnd(Object element) {
        // dummy implementation to make the code compile
    }

    public static void main(String[] args) {
    }
}
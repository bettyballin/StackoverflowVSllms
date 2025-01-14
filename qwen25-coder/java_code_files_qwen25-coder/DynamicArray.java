import java.lang.String;
// Example: Amortized cost in dynamic arrays resizing
public class DynamicArray {
    private int[] elements;
    private int capacity;
    private int size;

    public DynamicArray() {
        capacity = 10; // initial capacity
        elements = new int[capacity];
        size = 0;
    }

    public void add(int element) {
        if (size == capacity) {
            resize();  // This operation is O(n), but amortized.
        }
        elements[size++] = element;
    }

    private void resize() {
        int[] newElements = new int[capacity * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
        capacity *= 2;
    }

    public static void main(String[] args) {
    }
}
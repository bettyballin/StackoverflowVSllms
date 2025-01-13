import java.lang.String;
public class BoundedStack<T> {
    private final T[] buffer;
    private int head; // index of the top element
    private int size;

    public BoundedStack(int capacity) {
        buffer = (T[]) new Object[capacity];
        head = 0;
        size = 0;
    }

    public void push(T item) {
        if (size == buffer.length) {
            // remove oldest item (LIFO eviction)
            head = (head + 1) % buffer.length;
            size--;
        }
        buffer[(head + size) % buffer.length] = item;
        size++;
    }

    public T pop() {
        if (size == 0) {
            return null; // or throw an exception
        }
        T item = buffer[(head + size - 1) % buffer.length];
        size--;
        return item;
    }

	public static void main(String[] args) {
	}
}
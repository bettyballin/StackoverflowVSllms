import java.lang.String;
import java.util.ArrayDeque;
import java.util.Deque;

public class BoundedStack<T> {
    private final Deque<T> deque;
    private final int capacity;

    public BoundedStack(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<>(capacity);
    }

    public void push(T item) {
        if (deque.size() >= capacity) {
            deque.removeFirst(); // Remove the oldest element
        }
        deque.addLast(item); // Add the new element
    }

    public T pop() {
        return deque.pollLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }

	public static void main(String[] args) {
	}
}
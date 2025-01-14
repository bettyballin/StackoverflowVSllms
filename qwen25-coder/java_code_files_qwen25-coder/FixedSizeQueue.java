import java.lang.String;
import java.util.LinkedList;

public class FixedSizeQueue<T> {
    private final int maxSize;
    private final LinkedList<T> queue = new LinkedList<>();

    public FixedSizeQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void add(T element) {
        if (queue.size() >= maxSize) {
            queue.removeFirst();  // Remove oldest element
        }
        queue.addLast(element);  // Add new element at the end
    }

    public synchronized T getOldest() {
        return queue.peek();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

	public static void main(String[] args) {
	}
}
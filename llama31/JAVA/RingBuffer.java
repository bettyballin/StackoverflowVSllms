import java.lang.String;
public class RingBuffer<T> {
    private final T[] buffer;
    private int head; // index of the next element to be added
    private int tail; // index of the next element to be removed
    private int size; // current size of the buffer

    public RingBuffer(int capacity) {
        buffer = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void add(T element) {
        buffer[head] = element;
        head = (head + 1) % buffer.length;
        if (size == buffer.length) {
            tail = (tail + 1) % buffer.length;
        } else {
            size++;
        }
    }

    public T remove() {
        T element = buffer[tail];
        buffer[tail] = null;
        tail = (tail + 1) % buffer.length;
        size--;
        return element;
    }

	public static void main(String[] args) {
	}
}
import java.lang.String;
import java.lang.Integer;
public class CircularBuffer<T> {
    private final T[] buffer;
    private int head;
    private int count;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public CircularBuffer(int size) {
        this.buffer = (T[]) new Object[size];
        this.capacity = size;
        this.head = 0;
        this.count = 0;
    }

    public void add(T item) {
        buffer[head] = item;
        head = (head + 1) % capacity;
        if (count < capacity) {
            count++;
        }
    }

    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return buffer[(head - count + index + capacity) % capacity];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(get(i));
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer); // [1, 2, 3]
        buffer.add(4);
        System.out.println(buffer); // [2, 3, 4]
        buffer.add(5);
        System.out.println(buffer); // [3, 4, 5]
    }
}
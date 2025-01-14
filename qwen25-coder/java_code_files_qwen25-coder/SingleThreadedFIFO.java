import java.lang.String;
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Queue;

public class SingleThreadedFIFO {
    private final Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    public void enqueue(Integer item) {
        synchronized (lock) {
            queue.add(item);
        }
    }

    public Integer dequeue() {
        synchronized (lock) {
            return queue.poll();
        }
    }

	public static void main(String[] args) {
	}
}
import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    public void add(T item) {
        lock.lock();
        try {
            queue.add(item);
            notEmpty.signal(); // Notify the reader that the queue is not empty
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Wait until the queue is not empty
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

	public static void main(String[] args) {
	}
}
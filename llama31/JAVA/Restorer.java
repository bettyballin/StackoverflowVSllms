import java.util.concurrent.locks.ReentrantLock;

public class Restorer<T> {
    private final ReentrantLock lock = new ReentrantLock();

    public T restore(String from) throws Exception {
        lock.lock();
        try {
            // ...
            return null; // You need to return something, this is just a placeholder
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
    }
}
import java.lang.String;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AutoLock_1 {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void doSomething() {
        lock.readLock().lock();
        try {
            // critical section
        } finally {
            lock.readLock().unlock();
        }
    }

	public static void main(String[] args) {
	}
}
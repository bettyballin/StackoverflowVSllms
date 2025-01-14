import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AutoUnlock implements AutoCloseable {
    private final Lock lock;

    public AutoUnlock(Lock lock) {
        this.lock = lock;
        this.lock.lock();
    }

    @Override
    public void close() {
        if (lock != null) {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        // Example usage with a try-with-resources statement
        try (AutoUnlock autoUnlock = new AutoUnlock(readWriteLock.readLock())) {
            // Some code that uses the lock
            System.out.println("Reading data...");
        } // Lock is automatically released here

        // Example with write lock
        try (AutoUnlock autoUnlock = new AutoUnlock(readWriteLock.writeLock())) {
            // Some code that uses the write lock
            System.out.println("Writing data...");
        } // Write lock is automatically released here

        // If an exception occurs, the lock will still be released
    }
}
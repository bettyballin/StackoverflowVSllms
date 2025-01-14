import java.lang.String;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizationExample {
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock mutex = new ReentrantLock();
    private static final Semaphore semaphore = new Semaphore(3); // Allows 3 permits

    private int sharedData = 0;

    public void readerWriterReadOperation() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Reading: " + sharedData);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void readerWriterWriteOperation(int value) {
        try {
            readWriteLock.writeLock().lock();
            sharedData = value;
            System.out.println("Writing: " + sharedData);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void mutexOperation() {
        try {
            mutex.lock();
            // Critical section
            System.out.println("Mutex critical section");
        } finally {
            mutex.unlock();
        }
    }

    public void semaphoreOperation() throws InterruptedException {
        semaphore.acquire(); // Acquire a permit before proceeding
        try {
            // Access to the resource
            System.out.println("Semaphore critical section with 3 permits max");
        } finally {
            semaphore.release(); // Release the permit
        }
    }

	public static void main(String[] args) {
	}
}
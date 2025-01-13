import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MRSWLock {
    private final Lock lock = new ReentrantLock();
    private final Condition readerCondition = lock.newCondition();
    private int readerCount = 0;
    private boolean writerActive = false;

    public void readLock() {
        lock.lock();
        try {
            while (writerActive) {
                readerCondition.await();
            }
            readerCount++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void readUnlock() {
        lock.lock();
        try {
            readerCount--;
            if (readerCount == 0) {
                readerCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void writeLock() {
        lock.lock();
        try {
            while (readerCount > 0) {
                readerCondition.await();
            }
            writerActive = true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() {
        lock.lock();
        try {
            writerActive = false;
            readerCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MRSWLock lock = new MRSWLock();
        // Example usage:
        lock.readLock();
        System.out.println("Read lock acquired");
        lock.readUnlock();
        System.out.println("Read lock released");
        lock.writeLock();
        System.out.println("Write lock acquired");
        lock.writeUnlock();
        System.out.println("Write lock released");
    }
}
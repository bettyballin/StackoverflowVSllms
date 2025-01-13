import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SequenceCounter {
    private long currentValue;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public long getNextValue() {
        writeLock.lock(); // Changed from readLock to writeLock
        try {
            if (currentValue < Long.MAX_VALUE) {
                return currentValue++;
            } else {
                // handle overflow
                return Long.MAX_VALUE; // Added a return statement to handle overflow
            }
        } finally {
            writeLock.unlock(); // Changed from readLock to writeLock
        }
    }

    public void updateCurrentValue(long newValue) {
        writeLock.lock();
        try {
            currentValue = newValue;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        SequenceCounter counter = new SequenceCounter();
        counter.updateCurrentValue(10);
        System.out.println(counter.getNextValue()); // prints 10
        System.out.println(counter.getNextValue()); // prints 11
    }
}
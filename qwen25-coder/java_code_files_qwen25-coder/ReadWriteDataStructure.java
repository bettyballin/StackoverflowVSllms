import java.lang.String;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDataStructure {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

    // Method for reading data
    public void readData() {
        readLock.lock();
        try {
            // Your code to read from the data structure
            // Example: perform a quick hash table lookup
        } finally {
            readLock.unlock();
        }
    }

    // Method for writing data
    public void writeData() {
        writeLock.lock();
        try {
            // Your code to modify the data structure
        } finally {
            writeLock.unlock();
        }
    }

	public static void main(String[] args) {
	}
}
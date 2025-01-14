import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataProvider {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private List<Object> data;

    public void updateData() {
        rwl.writeLock().lock(); // Obtain write lock to block all readers
        try {
            // Update the data set here
            this.data = newData();
        } finally {
            rwl.writeLock().unlock(); // Release the write lock after updating
        }
    }

    public List<Object> getData() {
        rwl.readLock().lock(); // Obtain read lock (multiple threads can hold it)
        try {
            return data;
        } finally {
            rwl.readLock().unlock(); // Always release the read lock
        }
    }

    private List<Object> newData() {
        // Simulate data update logic here
        return List.of("updated", "data");
    }

    public static void main(String[] args) {
    }
}
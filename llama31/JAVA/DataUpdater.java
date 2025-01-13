import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataUpdater {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void updateData() {
        writeLock.lock();
        try {
            // update data here
        } finally {
            writeLock.unlock();
        }
    }

    public List getData() {
        readLock.lock();
        try {
            // return data here
            return null; // Add a return statement to make the code compile
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        DataUpdater updater = new DataUpdater();
        updater.updateData();
        updater.getData();
    }
}
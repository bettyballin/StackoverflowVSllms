import java.util.concurrent.locks.*;

public class ReentrantReadWriteLockManager {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    public void run() {
        try {
            // Your code here...
        } finally {
            if (readLock.isHeldByCurrentThread()) {
                readLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockManager manager = new ReentrantReadWriteLockManager();
        manager.run();
    }
}
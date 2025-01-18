import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); // obtain a lock in some way
        lock.lock();  // acquire the exclusive lock
        try {
            // perform operations that need to be synchronized here...
        } finally {
           lock.unlock();  // release the exclusive lock
        }
    }
}
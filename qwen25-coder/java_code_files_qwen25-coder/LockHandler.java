import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockHandler {

    private Lock lock = new ReentrantLock();

    {
        lock.lock();
        try {
            // perform actions requiring the lock
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
    }
}
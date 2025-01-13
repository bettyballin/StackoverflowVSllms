import java.lang.String;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AutoLock {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void doSomething() {
        try (Lock l = lock.readLock()) {
            l.lock();
            // critical section
        }
    }

    public static void main(String[] args) {
        AutoLock autoLock = new AutoLock();
        autoLock.doSomething();
    }
}
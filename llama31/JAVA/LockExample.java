import java.lang.String;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();

    public void method1() {
        synchronized (lock) {
            System.out.println("Inside synchronized block");
        }
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("Inside lock() block");
        } finally {
            lock.unlock();
        }
    }

	public static void main(String[] args) {
	}
}
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {
    ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock(); // Acquire the lock
        try {
            // Access resource here
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.accessResource();
    }
}
import java.lang.String;
public class SpinLock {
    private volatile boolean lock = false;

    public void acquire() {
        while (testAndSet(true)) {}
    }

    public void release() {
        lock = false;
    }

    private synchronized boolean testAndSet(boolean newValue) {
        boolean oldValue = lock;
        if (!oldValue) {
            lock = newValue;
        }
        return oldValue;
    }

    public static void main(String[] args) {
    }
}
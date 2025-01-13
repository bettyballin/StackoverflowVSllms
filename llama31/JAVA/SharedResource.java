import java.lang.String;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try {
            // access the shared resource
        } finally {
            lock.unlock();
        }
    }

	public static void main(String[] args) {
	}
}
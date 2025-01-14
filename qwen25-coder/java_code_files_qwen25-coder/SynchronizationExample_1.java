import java.lang.String;
public class SynchronizationExample_1 {

    private final Object lock = new Object();

    public synchronized void synchronizedMethod() {
        // This method is fully synchronized for this instance.
    }

    public void blockMethod() {
        synchronized (lock) {
            // Only this block of code is synchronized, not the whole method.
        }
    }

    public static synchronized void staticSynchronizedMethod() {
        // This method is synchronized on the class level.
    }

	public static void main(String[] args) {
	}
}
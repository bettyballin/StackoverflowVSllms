import java.lang.String;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadSafetyChecker {

    private final AtomicBoolean inUse = new AtomicBoolean(false);

    /**
     * Check if the current method is called from the same thread.
     * If another thread tries to call it, an exception is thrown.
     */
    public void assertSingleThreadedAccess() {
        Thread currentThread = Thread.currentThread();
        String methodName = new Throwable().getStackTrace()[1].getMethodName();

        boolean wasFree = inUse.compareAndSet(false, true);
        if (!wasFree) {
            throw new RuntimeException("Method " + methodName + " is not thread-safe. Called by " + currentThread.getName());
        }

        // Remember to release the flag after the method has completed
        Runtime.getRuntime().addShutdownHook(new Thread(() -> inUse.set(false)));
    }

    /**
     * To be called at the end of a method that needs to enforce single-threaded access.
     */
    public void releaseAccess() {
        inUse.set(false);
    }
}

// Example usage:
class SomeService {

    private final ThreadSafetyChecker checker = new ThreadSafetyChecker();

    public void someMethod() {
        checker.assertSingleThreadedAccess();
        try {
            // method implementation here
        } finally {
            checker.releaseAccess();
        }
    }

	public static void main(String[] args) {
	}
}
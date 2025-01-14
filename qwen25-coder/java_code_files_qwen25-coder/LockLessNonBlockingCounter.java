import java.lang.String;
import java.util.concurrent.atomic.AtomicInteger;

public class LockLessNonBlockingCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        // This operation is atomic and does not use locks, making it lockless.
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }

	public static void main(String[] args) {
	}
}
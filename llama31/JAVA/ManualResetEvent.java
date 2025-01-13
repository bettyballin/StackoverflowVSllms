import java.lang.String;
import java.util.concurrent.Semaphore;

public class ManualResetEvent {
    private final Semaphore semaphore;

    public ManualResetEvent(boolean initialState) {
        semaphore = new Semaphore(initialState ? 1 : 0);
    }

    public void set() {
        semaphore.release();
    }

    public void reset() {
        semaphore.drainPermits();
    }

    public void waitOne() throws InterruptedException {
        semaphore.acquire();
    }

	public static void main(String[] args) {
	}
}
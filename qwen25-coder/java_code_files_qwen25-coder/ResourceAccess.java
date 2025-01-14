import java.util.concurrent.Semaphore;

public class ResourceAccess {
    Semaphore semaphore = new Semaphore(2); // Allow two permits

    public void accessResource() {
        try {
            semaphore.acquire(); // Acquire a permit
            // Access resource here
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}
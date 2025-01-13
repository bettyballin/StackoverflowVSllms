import java.util.concurrent.Semaphore;

public class SemaphoreExample_1 {
    private Semaphore _semaphore = new Semaphore(5); // Allow 5 threads at a time

    public void accessResource() {
        try {
            _semaphore.acquire();
            // Access shared resource
        } finally {
            _semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        example.accessResource();
    }
}
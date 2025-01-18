import java.util.concurrent.Semaphore;

public class SemaphoredResource {
    // only 10 resources available in this example.
    Semaphore semaphores = new Semaphore(10);

    void useResource() throws InterruptedException {
        try {
            semaphores.acquire();   // acquires a permit
            // Critical Section of Code: Resource usage should be done here.
        } finally {
            semaphores.release();  // Releases the acquired permits and increments its value.
        }
    }

    public static void main(String[] args) {
    }
}
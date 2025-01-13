import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeDataCache {
    private final Lock lock = new ReentrantLock();

    private SomeData[] getSomeDataByEmail(WebServiceInterface service, String email) {
        final String key = "Data-" + email;
        lock.lock();
        try {
            // synchronized code here
        } finally {
            lock.unlock();
        }
        return null; // Added return statement to avoid compilation error
    }

    public static void main(String[] args) {
    }
}

// Assuming SomeData and WebServiceInterface are classes/interfaces defined elsewhere
class SomeData {}

interface WebServiceInterface {}
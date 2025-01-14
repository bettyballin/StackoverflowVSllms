import java.lang.String;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIDGenerator {
    // AtomicLong is thread-safe and provides an incremented value
    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());

    public synchronized static String generateUniqueID() {
        // Combining UUID.randomUUID() with a timestamp/counter to ensure uniqueness
        return UUID.randomUUID().toString() + "-" + counter.incrementAndGet();
    }

    public static void main(String[] args) {
        // Generates and prints 10 unique IDs for demonstration
        for (int i = 0; i < 10; i++) {
            System.out.println(generateUniqueID());
        }
    }
}
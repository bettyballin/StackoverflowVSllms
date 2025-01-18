import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueNegativeGenerator {
    private final AtomicLong counter = new AtomicLong(1);
    private final Set<Long> seen = Collections.synchronizedSet(new HashSet<>());

    public long generateUniqueNegativeNumber() {
        boolean added = false;
        long nextVal = 0L;

        do {
            nextVal = -counter.getAndIncrement();
            if (nextVal > 0) {
                throw new RuntimeException("Unfortunately, long overflow.");
            }
            added = seen.add(nextVal);
        } while(!added);
        return nextVal;
    }

    public static void main(String[] args) {
    }
}
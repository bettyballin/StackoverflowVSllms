import java.lang.Integer;
import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NegativeUniqueIdGenerator {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final ConcurrentHashMap<Integer, Boolean> cache = new ConcurrentHashMap<>();

    public Integer generateUniqueNegativeIds() {
        int id;
        do {
            id = -counter.incrementAndGet();
        } while (!cache.putIfAbsent(id, true));
        return id;
    }

	public static void main(String[] args) {
	}
}
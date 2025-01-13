/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NegativeUniqueIdGenerator {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final ConcurrentHashMap<Integer, Boolean> cache = new ConcurrentHashMap();

    public Integer generateUniqueNegativeIds() {
        int n;
        while (!this.cache.putIfAbsent(n = -this.counter.incrementAndGet(), true).booleanValue()) {
        }
        return n;
    }

    public static void main(String[] stringArray) {
    }
}

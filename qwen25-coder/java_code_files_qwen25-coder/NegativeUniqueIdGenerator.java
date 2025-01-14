import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class NegativeUniqueIdGenerator {
    private final Random random = new Random();
    // Use ConcurrentHashMap where each key is a unique negative ID and the value is irrelevant (e.g., Boolean.TRUE)
    private final ConcurrentHashMap<Integer, Boolean> seen = new ConcurrentHashMap<>();

    public Integer generateUniqueNegativeIds() {
        int result;
        do {
            result = random.nextInt();
            if (result > 0) {
                result *= -1;
            }
            // Try to put the ID in the map, atomically. If it's already there, this will return null.
        } while (seen.putIfAbsent(result, Boolean.TRUE) != null);
        return result;
    }

    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 10000;
        final List<Integer> positives = Collections.synchronizedList(new ArrayList<>());
        final NegativeUniqueIdGenerator nuig = new NegativeUniqueIdGenerator();
        Thread[] workers = new Thread[NUMBER_OF_THREADS];
        long start = System.nanoTime();
        for (int i = 0; i < workers.length; i++) {
            Runnable runnable = () -> {
                int number = nuig.generateUniqueNegativeIds();
                if (number > 0) {
                    positives.add(number);
                }
            };
            workers[i] = new Thread(runnable);
            workers[i].start();
        }
        for (int i = 0; i < workers.length; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException ie) {}
        }
        long end = System.nanoTime();

        int uniqueCount = nuig.seen.size();
        System.out.println(String.format("duration = %dns", (end - start)));
        System.out.println(String.format("#threads = %d", NUMBER_OF_THREADS));
        System.out.println(String.format("#uniques = %d", uniqueCount));
        System.out.println(String.format("#positives = %d", positives.size()));
        System.out.println(String.format("#duplicates = %d", NUMBER_OF_THREADS - uniqueCount));
        System.out.println(String.format("ratio = %f",
                ((double) NUMBER_OF_THREADS - uniqueCount)
                        / NUMBER_OF_THREADS));
        assert uniqueCount == NUMBER_OF_THREADS;
    }
}
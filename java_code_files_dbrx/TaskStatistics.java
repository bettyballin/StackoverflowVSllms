import java.lang.String;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class TaskStatistics {
    // Inner class storing task duration statistics (milliseconds)
    public static final class Statistics {
        private AtomicLong sum = new AtomicLong();  // Total time spent for tasks of this type
        private AtomicInteger count = new AtomicInteger(); // Number of tasks executed of this type

        // ... add methods to compute mean, median, standard deviation etc. as getters using the sum and count values
    }

    private final ConcurrentMap<String, Statistics> statsMap = new ConcurrentHashMap<>();
    private ExecutorService executor;

    public TaskStatistics(ExecutorService executor) {
        this.executor = executor;
    }

    // Each task should have an associated Runnable or Callable implementation that looks like the following:
    class TypedTask implements Runnable {
        private final String type;

        public TypedTask(String type) { this.type = type; }

        @Override
        public void run() {
            // Record start time before actual task execution
            long startTime = System.currentTimeMillis();

            try {
                // Your tasks go here...
            } finally {
                 long stopTime = System.currentTimeMillis();
                 long duration = (stopTime - startTime);
                 statsMap.get(type).sum.addAndGet(duration);
                 statsMap.get(type).count.incrementAndGet();
             }
        }
    }

    public static void main(String[] args) {
    }
}
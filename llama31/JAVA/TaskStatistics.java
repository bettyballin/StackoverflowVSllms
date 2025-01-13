import java.lang.String;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.Arrays;

public class TaskStatistics {
    private final ConcurrentHashMap<String, TaskStats> statsMap = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void executeTask(Runnable task, String type) {
        long startTime = System.nanoTime();
        executor.execute(() -> {
            try {
                task.run();
            } finally {
                long endTime = System.nanoTime();
                updateStats(type, endTime - startTime);
            }
        });
    }

    private void updateStats(String type, long duration) {
        statsMap.computeIfAbsent(type, k -> new TaskStats()).update(duration);
    }

    public void printStats() {
        for (Map.Entry<String, TaskStats> entry : statsMap.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            TaskStats stats = entry.getValue();
            System.out.println("  Mean: " + stats.getMean());
            System.out.println("  Median: " + stats.getMedian());
            System.out.println("  Standard Deviation: " + stats.getStdDev());
        }
    }

    private static class TaskStats {
        private final AtomicLong sum = new AtomicLong();
        private final AtomicLong count = new AtomicLong();
        private final AtomicReferenceArray<Long> durations = new AtomicReferenceArray<>(100);
        private final String type;

        public TaskStats(String type) {
            this.type = type;
        }

        public void update(long duration) {
            sum.addAndGet(duration);
            count.incrementAndGet();
            int index = (int) (count.get() % durations.length());
            durations.set(index, duration);
        }

        public String getType() {
            return type;
        }

        public double getMean() {
            return sum.get() / (double) count.get();
        }

        public double getMedian() {
            long[] durationsCopy = new long[(int) count.get()];
            for (int i = 0; i < count.get(); i++) {
                durationsCopy[i] = durations.get(i % durations.length());
            }
            Arrays.sort(durationsCopy);
            int mid = (int) (count.get() / 2);
            return durationsCopy[mid];
        }

        public double getStdDev() {
            double mean = getMean();
            double sumSquares = 0;
            for (int i = 0; i < count.get(); i++) {
                double diff = durations.get(i % durations.length()) - mean;
                sumSquares += diff * diff;
            }
            return Math.sqrt(sumSquares / count.get());
        }
    }

    public static void main(String[] args) {
        TaskStatistics taskStatistics = new TaskStatistics();
        taskStatistics.executeTask(() -> {
            // Example task
            System.out.println("Task executed");
        }, "example");
        try {
            Thread.sleep(100); // wait for task to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        taskStatistics.printStats();
    }
}
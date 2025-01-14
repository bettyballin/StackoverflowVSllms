import java.util.*;
import java.util.concurrent.*;

public class TaskTracker {
    private final ConcurrentHashMap<String, List<Long>> executionTimes = new ConcurrentHashMap<>();

    public void addExecutionTime(String taskType, long timeTaken) {
        // For each task type, add the execution time to a list
        executionTimes.computeIfAbsent(taskType, k -> Collections.synchronizedList(new ArrayList<>()))
                      .add(timeTaken);
    }

    private double calculateMean(List<Long> times) {
        return times.stream().mapToDouble(Long::doubleValue).average().orElse(Double.NaN);
    }

    private double calculateMedian(List<Long> times) {
        long[] sortedTimes = times.stream().sorted().distinct().mapToLong(Long::longValue).toArray();
        int middle = sortedTimes.length / 2;
        return (middle % 2 != 0) ?
                sortedTimes[middle] :
                ((sortedTimes[middle - 1] + sortedTimes[middle]) / 2.0);
    }

    private double calculateStandardDeviation(List<Long> times, double mean) {
        return Math.sqrt(times.stream()
                             .mapToDouble(num -> Math.pow(num - mean, 2))
                             .average().orElse(Double.NaN));
    }

    public void printStatistics() {
        for (Map.Entry<String, List<Long>> entry : executionTimes.entrySet()) {
            String taskType = entry.getKey();
            List<Long> times = entry.getValue();
            double mean = calculateMean(times);
            double median = calculateMedian(times);
            double stdDeviation = calculateStandardDeviation(times, mean);

            System.out.printf("Task Type: %s%n", taskType);
            System.out.printf("Average Time: %.2fms%n", mean);
            System.out.printf("Median Time: %.2fms%n", median);
            System.out.printf("Standard Deviation: %.2fms%n%n", stdDeviation);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TaskTracker tracker = new TaskTracker();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Example tasks
        List<Runnable> tasks = Arrays.asList(
            () -> trackTask(tracker, "a", 20),
            () -> trackTask(tracker, "b", 45),
            () -> trackTask(tracker, "a", 30),
            () -> trackTask(tracker, "b", 60)
        );

        for (Runnable task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();
        if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
            System.out.println("Executor did not terminate in a given time period");
        }

        tracker.printStatistics();
    }

    private static void trackTask(TaskTracker tracker, String type, long duration) {
        long start = System.currentTimeMillis();
        // Simulate task execution
        try { Thread.sleep(duration); } catch (InterruptedException e) { }
        long end = System.currentTimeMillis();

        tracker.addExecutionTime(type, end - start);
    }
}
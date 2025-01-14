import java.lang.String;
// Example of a simple data parallel task using Java's ForkJoinPool (FJP)
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start, end;

    public ParallelSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        int length = end - start;
        if (length <= 1000) { // Threshold for switching to sequential computation
            return computeSequentially();
        }
        ParallelSum leftTask = new ParallelSum(numbers, start, start + length / 2);
        leftTask.fork(); // For asynchronous execution
        ParallelSum rightTask = new ParallelSum(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute(); // This is executed synchronously
        Long leftResult = leftTask.join(); // Collecting the result of the asynchronously executed task
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = new long[1_000_000];
        // Initialize array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long finalResult = forkJoinPool.invoke(new ParallelSum(numbers, 0, numbers.length));
        System.out.println(finalResult);
    }
}
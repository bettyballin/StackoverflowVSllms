// This is a sample function that performs array calculation on all available cores using Java's ForkJoinPool API.
import java.util.*;
import java.util.concurrent.*;

public class Calculator {
    private int[] calculate(int[] input) {
        ForkJoinPool pool = new ForkJoinPool();
        ParallelCalc task = new ParallelCalc(input, 0, input.length);
        return pool.invoke(task); // Compute the result using ForkJoinPool
    }
}

class ParallelCalc extends RecursiveTask<int[]> {
    private int[] input;
    private int start;
    private int end;
    private static final int THRESHOLD = 1000; // Threshold for splitting tasks

    public ParallelCalc(int[] input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }

    @Override
    protected int[] compute() {
        if (end - start <= THRESHOLD) {
            // Compute directly
            int[] result = new int[end - start];
            for (int i = start; i < end; i++) {
                // Sample computation: multiply each element by 2
                result[i - start] = input[i] * 2;
            }
            return result;
        } else {
            // Split tasks
            int mid = (start + end) / 2;
            ParallelCalc leftTask = new ParallelCalc(input, start, mid);
            ParallelCalc rightTask = new ParallelCalc(input, mid, end);
            ForkJoinTask.invokeAll(leftTask, rightTask); // Modified to include class name
            int[] leftResult = leftTask.join();
            int[] rightResult = rightTask.join();
            // Combine results
            int[] result = new int[leftResult.length + rightResult.length];
            System.arraycopy(leftResult, 0, result, 0, leftResult.length);
            System.arraycopy(rightResult, 0, result, leftResult.length, rightResult.length);
            return result;
        }
    }
}
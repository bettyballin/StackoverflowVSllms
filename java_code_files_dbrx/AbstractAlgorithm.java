import java.lang.String;
import java.lang.Integer;
import java.util.concurrent.*;

public class AbstractAlgorithm {
    // Assuming the return types of steps as Integer to simplify example:
    private final Callable<Integer> stepA;
    private final Callable<Integer> stepB;
    private final Callable<Integer> stepC;

    public AbstractAlgorithm(Callable<Integer> _stepA, Callable<Integer> _stepB, Callable<Integer> _stepC) {
        this.stepA = _stepA;
        this.stepB = _stepB;
        this.stepC = _stepC;
    }

    public int executeAlgorithm() throws InterruptedException, ExecutionException {
        // Create a fixed thread pool executor service with 3 threads (one per step)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit each Callable to the ExecutorService and receive Future objects:
        Future<Integer> futureA = executor.submit(stepA);
        Future<Integer> futureB = executor.submit(stepB);
        Future<Integer> futureC = executor.submit(stepC);

        // Wait for results of steps A, B and C:
        int resultA = futureA.get();  // blocks until step A is complete
        int resultB = futureB.get();  // blocks until step B is complete
        int resultC = futureC.get();  // blocks until step C is complete

        // Shutdown the ExecutorService after tasks are finished:
        executor.shutdown();

        // Step D can now use results from steps A, B and C to compute an overall answer, which I assume as sum of all results for simplicity.
        return resultA + resultB + resultC;
    }
    
    public static void main(String[] args) {
    }
}
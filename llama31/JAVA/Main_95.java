import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_95 {
    public static void main(String[] args) {
        int dim = 10; // Define the dimension
        int steps = 5; // Define the number of steps
        int[] partMap = new int[dim * dim * dim]; // Initialize the partMap array
        int[] projection = new int[dim * dim]; // Initialize the projection array

        int numThreads = Runtime.getRuntime().availableProcessors(); 
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int stage = 1; stage < steps; stage++) {
            for (int j = 0; j < dim; j++) {
                for (int i = 0; i < dim; i++) {
                    final int stageFinal = stage;
                    final int jFinal = j;
                    final int iFinal = i;

                    executor.submit(() -> {
                        int sum = 0; // Declare sum as a local variable
                        for (int k = 0; k < dim; k++) {
                            if (partMap[(((iFinal * dim) + k) * dim) + jFinal] >= stageFinal) {
                                sum++;
                            }
                        }
                        projection[(jFinal * dim) + iFinal] = sum;
                    });
                }
            }
        }

        executor.shutdown();
    }
}
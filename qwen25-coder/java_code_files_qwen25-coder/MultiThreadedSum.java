import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedSum {
    private static final int DIM = 1000;
    private static final int STEPS = 7;
    private static final int NUM_THREADS = 2; // or 4, depending on your cores

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        int[] partMap = generatePartMap(); // method to load your data
        int[] projection = new int[DIM * DIM];

        for (int stage = 1; stage < STEPS; stage++) {
            for (int j = 0; j < DIM; j += NUM_THREADS) {
                for (int t = 0; t < NUM_THREADS && j + t < DIM; t++) {
                    final int currentJ = j + t;
                    executor.submit(() -> {
                        for (int i = 0; i < DIM; i++) {
                            int sum = 0;
                            for (int k = 0; k < DIM; k++)
                                if (partMap[(((currentJ * DIM) + k) * DIM) + currentJ] >= stage)
                                    sum++;
                            projection[(currentJ * DIM) + i] = sum;
                        }
                    });
                }
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        // Output or further process the projection array
    }

    private static int[] generatePartMap() {
        // Dummy data generation for demonstration purposes
        return new int[DIM * DIM * DIM];
    }
}
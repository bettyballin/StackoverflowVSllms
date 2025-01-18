import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Fill with real data (either 50 words per line or the entire block of memory X)
        int wordLength = 50; // Number of elements per row in the original block
        List<Double> originalBlock = new ArrayList<>();
        for (int i = 0; i < wordLength * 4; i++) { // Adjust size as needed
            originalBlock.add((double) i + 0.1);
        }

        ExecutorService pool = Executors.newFixedThreadPool(4); // Use at most four threads
        List<Future<Double[][]>> taskList = new ArrayList<>();
        int thread = 0;
        for (int i = 0; i < originalBlock.size() / wordLength / 2; ++i) {
            // There would be only half word length in each block because we're splitting the lines
            // Each thread will extract 1st and then every second element from a row
            // Total rowsNum*increment steps as calculated based on block size in DataInterleaving::call()
            taskList.add(pool.<Double[][]>submit(new DataInterleaving(originalBlock, i, 2 /* increment by two for each thread */, thread++, wordLength / 4)));
            // Here offset and increment are given according to which columns we're extracting from each row
            // The block size is set based on interleaved blocks (in this case it's the total original word length divided by number of parallel threads)
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);

        // Process the results if necessary
        for (Future<Double[][]> future : taskList) {
            Double[][] result = future.get();
            // Do something with the result
        }
    }
}

class DataInterleaving implements Callable<Double[][]> {
    private List<Double> originalBlock;
    private int offset;
    private int increment;
    private int thread;
    private int blockSize;

    public DataInterleaving(List<Double> originalBlock, int offset, int increment, int thread, int blockSize) {
        this.originalBlock = originalBlock;
        this.offset = offset;
        this.increment = increment;
        this.thread = thread;
        this.blockSize = blockSize;
    }

    @Override
    public Double[][] call() throws Exception {
        // Implement the actual data interleaving logic here

        // For this example, we'll just return a dummy array
        Double[][] result = new Double[blockSize][];
        for (int i = 0; i < blockSize; i++) {
            result[i] = new Double[originalBlock.size() / blockSize];
            // Fill with dummy data
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 0.0; // Autoboxing from double to Double
            }
        }
        return result;
    }
}
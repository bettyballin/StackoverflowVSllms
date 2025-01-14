import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class DistributedSearch extends RecursiveTask<Long> {
    private final List<String> dataChunk;
    private final String queryTerm;

    public DistributedSearch(List<String> dataChunk, String queryTerm) {
        this.dataChunk = dataChunk;
        this.queryTerm = queryTerm.toLowerCase();
    }

    @Override
    protected Long compute() {
        if (dataChunk.size() < 1000) { // Threshold for further splitting
            return countOccurrences(dataChunk, queryTerm);
        } else {
            int middle = dataChunk.size() / 2;
            DistributedSearch leftTask = new DistributedSearch(dataChunk.subList(0, middle), queryTerm);
            DistributedSearch rightTask = new DistributedSearch(dataChunk.subList(middle, dataChunk.size()), queryTerm);

            leftTask.fork(); // Process the left half asynchronously
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }

    private long countOccurrences(List<String> chunk, String term) {
        return chunk.stream().filter(line -> line.toLowerCase().contains(term)).count();
    }

    public static void main(String[] args) {
        // Large dataset representing product descriptions
        List<String> dataset =
                java.util.Collections.nCopies(10000, "stack overflow is a popular site for developers.");

        DistributedSearch searchTask = new DistributedSearch(dataset, "stack overflow");
        long result = ForkJoinPool.commonPool().invoke(searchTask); // Use invoke to get the result synchronously

        System.out.println("Occurrences of 'stack overflow': " + result);
    }
}
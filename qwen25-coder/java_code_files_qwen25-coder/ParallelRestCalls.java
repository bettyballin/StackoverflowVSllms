import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Map;

public class ParallelRestCalls {

    public static void main(String[] args) {
        // Create an executor service with 3 threads (or more if necessary)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> callA = CompletableFuture.supplyAsync(() -> callEndpoint("URL_A"), executor);
        CompletableFuture<String> callB = CompletableFuture.supplyAsync(() -> callEndpoint("URL_B"), executor);
        CompletableFuture<String> callC = CompletableFuture.supplyAsync(() -> callEndpoint("URL_C"), executor);

        // Combine the results from all three calls
        CompletableFuture<Map<String, String>> combinedResult = CompletableFuture.allOf(callA, callB, callC)
                .thenApply(v -> Map.of(
                        "resultA", callA.join(),
                        "resultB", callB.join(),
                        "resultC", callC.join()
                ));

        // Handle the combined result
        combinedResult.thenAccept(result -> {
            System.out.println("Combined Results: ");
            result.forEach((k, v) -> System.out.println(k + ": " + v));
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        // Wait for the combined result to complete
        combinedResult.join();

        // Shutdown the executor service
        executor.shutdown();
    }

    private static String callEndpoint(String url) {
        // Implement your REST call logic here
        // For example, using HttpClient or any other library
        return "Response from " + url; // Placeholder response
    }
}
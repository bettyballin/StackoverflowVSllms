import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class LongPollingExample {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void pollServer() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.example.com/data"))
                .GET()
                .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(data -> {
                // Process the data
                System.out.println("Received data: " + data);
                // Immediately make another request
                pollServer();
            })
            .exceptionally(error -> {
                System.err.println("Error: " + error.getMessage());
                return null;
            });
    }

    public static void main(String[] args) {
        // Start polling
        pollServer();

        // Keep the program running indefinitely
        synchronized (LongPollingExample.class) {
            try {
                LongPollingExample.class.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Main thread interrupted");
            }
        }
    }
}
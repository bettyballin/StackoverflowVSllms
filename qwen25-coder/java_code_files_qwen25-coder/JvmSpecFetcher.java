import java.lang.String;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JvmSpecFetcher {
    public static void main(String[] args) {
        String url = "https://docs.oracle.com/javase/specs/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Check the following URL for the latest JVM Specification: " + url);
            } else {
                System.out.println("Failed to retrieve page; status code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.err.println("Error fetching the page: " + e.getMessage());
        }
    }
}
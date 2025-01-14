import java.lang.String;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        // Create a HttpClient with timeout settings
        var client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10)) // connection timeout
                .build();

        var request = HttpRequest.newBuilder()
                .uri(new URI("https://example.com/api"))
                .timeout(Duration.ofMinutes(1)) // request timeout
                .GET() // specify GET method
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
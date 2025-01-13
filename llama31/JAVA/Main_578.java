import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class Main_578 {
    public static void main(String[] args) throws IOException {
        // Example using Apache HttpClient
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.com");
        request.setHeader("User-Agent", "YourService/1.0");
        
        // You might also want to execute the request and handle the response
        // For demonstration purposes only; ensure proper handling in production code
        try (CloseableHttpResponse response = client.execute(request)) {
            System.out.println("Response status: " + response.getStatusLine().getStatusCode());
        }
    }
}
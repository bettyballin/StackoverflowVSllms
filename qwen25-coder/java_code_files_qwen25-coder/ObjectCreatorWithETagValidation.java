import java.lang.String;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObjectCreatorWithETagValidation {
    public boolean createObject(String objectData, String eTag) {
        // Assume an HTTP client and server that support ETag headers
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://adam-server.com/objects"))
                .header("If-Match", eTag)
                .POST(HttpRequest.BodyPublishers.ofString(objectData))
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) { // Created
                System.out.println("Object created successfully.");
                return true;
            } else if (response.statusCode() == 412) { // Precondition Failed
                System.err.println("ETag did not match, object might have been updated by another process.");
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
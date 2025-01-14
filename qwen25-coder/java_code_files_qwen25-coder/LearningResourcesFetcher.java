import java.lang.String;
// Example Java code snippet to demonstrate accessing online learning resources programmatically
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LearningResourcesFetcher {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        // Request to fetch Microsoft Docs for VSTS 2008
        HttpRequest requestMicrosoftDocs = HttpRequest.newBuilder()
            .uri(URI.create("https://docs.microsoft.com/en-us/previous-versions/msp-n-pff763"))
            .build();

        HttpResponse<String> responseMicrosoftDocs = client.send(requestMicrosoftDocs, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response from Microsoft Docs: " + responseMicrosoftDocs.statusCode());

        // Request to fetch Channel 9 videos (if still active and available)
        HttpRequest requestChannel9 = HttpRequest.newBuilder()
            .uri(URI.create("https://channel9.msdn.com/"))
            .build();

        HttpResponse<String> responseChannel9 = client.send(requestChannel9, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response from Channel 9: " + responseChannel9.statusCode());

        // Note: Pluralsight and Udemy can be accessed directly through their web interfaces
    }
}
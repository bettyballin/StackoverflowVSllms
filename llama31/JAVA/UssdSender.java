import java.lang.String;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UssdSender {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ussdCode = "*123#"; // Your registered USSD code
        String message = "Hello, USSD!"; // The message to send
        String msisdn = "+1234567890"; // The recipient's phone number

        String apiUrl = "https://example.com/ussd/api/send"; // Your USSD API endpoint
        String apiKey = "your_api_key"; // Your USSD API key

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("ussd_code=" + ussdCode + "&message=" + message + "&msisdn=" + msisdn))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
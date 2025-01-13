/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UssdSender {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String string = "*123#";
        String string2 = "Hello, USSD!";
        String string3 = "+1234567890";
        String string4 = "https://example.com/ussd/api/send";
        String string5 = "your_api_key";
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(string4)).header("Authorization", "Bearer " + string5).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString("ussd_code=" + string + "&message=" + string2 + "&msisdn=" + string3)).build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}

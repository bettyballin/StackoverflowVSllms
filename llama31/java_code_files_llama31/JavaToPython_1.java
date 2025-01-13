/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaToPython_1 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("http://localhost:5000/tokenize")).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString("{\"text\":\"Hello, world!\"}")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}

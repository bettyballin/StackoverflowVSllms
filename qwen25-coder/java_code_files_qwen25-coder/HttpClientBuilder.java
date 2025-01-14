import java.lang.String;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.time.Duration;

public class HttpClientBuilder {
    HttpClient client = HttpClient.newBuilder()
           .followRedirects(Redirect.NEVER)
           .connectTimeout(Duration.ofSeconds(10))
           .build();

    public static void main(String[] args) {
    }
}
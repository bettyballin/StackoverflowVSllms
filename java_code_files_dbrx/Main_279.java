import java.net.http.HttpClient;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofMillis(60 * 1000)) // in milliseconds, e.g., 1 min here
            .build();
    }
}
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.List;

public class HttpHeaderReader {
    public static void main(String[] args) throws Exception {
        String url = "http://example.com"; // replace with the target URL
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("HEAD");
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
    }
}
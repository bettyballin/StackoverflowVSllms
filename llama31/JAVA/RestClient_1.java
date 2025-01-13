import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestClient_1_1 {
    public void get(String url) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        java.util.Scanner scanner = new java.util.Scanner(connection.getInputStream()).useDelimiter("\\A");
        String response = scanner.hasNext() ? scanner.next() : "";
        System.out.println(response);
    }

    public static void main(String[] args) throws Exception {
        RestClient_1 client = new RestClient_1();
        client.get("http://example.com");
    }
}
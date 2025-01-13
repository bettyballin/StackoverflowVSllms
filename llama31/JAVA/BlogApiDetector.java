import java.lang.String;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BlogApiDetector {
    public static void main(String[] args) throws IOException {
        String blogUrl = "http://example.com";
        String blogType = detectBlogApi(blogUrl);
        System.out.println("Blog type: " + blogType);
    }

    public static String detectBlogApi(String blogUrl) throws IOException {
        URL url = new URL(blogUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();

        // Check URL pattern
        if (blogUrl.contains("blogger.com")) {
            return "Blogger";
        } else if (blogUrl.contains("wordpress.com")) {
            return "WordPress";
        }

        // Check HTTP headers
        String[] headers = connection.getHeaderFields().keySet().toArray(new String[0]);
        for (String header : headers) {
            if (header.equals("X-Powered-By") && connection.getHeaderField(header).contains("WordPress")) {
                return "WordPress";
            }
        }

        // Check meta tags
        String html = new Scanner(url.openStream()).useDelimiter("\\Z").next();
        if (html.contains("<link rel=\"alternate\" type=\"application/rss+xml\"")) {
            return "RSS";
        }

        return "Unknown";
    }
}
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BlogDetector {

    private static final String[] WORDPRESS_SIGNATURES = {
        "wp-content/themes",
        "wp-includes/",
        "<link rel='https?://api.w.org/'",
        "<meta name='generator' content='WordPress"
    };

    public static void main(String[] args) throws Exception {
        String blogUrl = "http://example.com"; // Replace with the URL you want to check
        BlogType detectedBlogType = detectBlogType(blogUrl);
        System.out.println("Detected Blog Type: " + detectedBlogType);
    }

    private static BlogType detectBlogType(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Check for WordPress signatures
            String pageContent = content.toString();
            for (String signature : WORDPRESS_SIGNATURES) {
                if (pageContent.toLowerCase().contains(signature.toLowerCase())) {
                    return BlogType.WORDPRESS;
                }
            }

            // Add more checks here for other blog types

        } else {
            System.out.println("Failed to connect: " + responseCode);
        }
        return BlogType.UNKNOWN;
    }

    enum BlogType {
        WORDPRESS,
        BLOGGER,
        UNKNOWN
        // Add more blog types as necessary
    }
}
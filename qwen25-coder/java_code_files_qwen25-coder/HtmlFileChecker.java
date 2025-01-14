import java.lang.String;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlFileChecker {

    public static boolean isHtml(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            return false; // Not found or other error
        }
        
        String contentType = connection.getContentType();
        return "text/html".equalsIgnoreCase(contentType);
    }

    public static void main(String[] args) {
        try {
            boolean isHtml = isHtml("http://example.com");
            System.out.println("Is the URL an HTML file? " + isHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
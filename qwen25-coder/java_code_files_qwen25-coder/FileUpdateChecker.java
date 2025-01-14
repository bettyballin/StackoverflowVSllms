import java.lang.String;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class FileUpdateChecker {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com/yourfile.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // HEAD request to get the headers without body
        connection.setRequestMethod("HEAD");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            long lastModifiedMillis = connection.getLastModified();
            Date lastModifiedDate = new Date(lastModifiedMillis);
            System.out.println("Last Modified: " + lastModifiedDate);
        } else {
            System.out.println("Failed to retrieve headers. Response Code: " + responseCode);
        }

        connection.disconnect();
    }
}
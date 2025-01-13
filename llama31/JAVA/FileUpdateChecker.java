import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUpdateChecker {
    public static void main(String[] args) throws IOException, ParseException {
        URL url = new URL("http://example.com/your-static-file.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set If-Modified-Since header with last known modified date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        Date lastModifiedDate = dateFormat.parse("Wed, 21 Jan 2020 14:30:00 GMT");
        connection.setRequestProperty("If-Modified-Since", dateFormat.format(lastModifiedDate));

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            System.out.println("File has been updated.");
        } else if (responseCode == 304) {
            System.out.println("File hasn't been modified.");
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}
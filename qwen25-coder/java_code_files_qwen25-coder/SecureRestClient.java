import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

public class SecureRestClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/api/resource");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        
        // Example header
        connection.setRequestProperty("Custom-Header", "SensitiveData");

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = "{\"data\": \"more sensitive data\"}".getBytes("utf-8");
            os.write(input, 0, input.length);           
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
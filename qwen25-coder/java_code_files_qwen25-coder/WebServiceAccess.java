import java.lang.String;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class WebServiceAccess {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.example.com/service");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        String authString = "username:password"; // Use your credentials
        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
        String authHeader = "Basic " + encodedAuthString;
        
        connection.setRequestProperty("Authorization", authHeader);
        connection.setRequestProperty("Content-Type", "application/json"); // Adjust as per service requirements
        
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
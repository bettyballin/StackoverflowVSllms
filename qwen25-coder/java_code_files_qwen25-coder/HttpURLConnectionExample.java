import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpURLConnectionExample {
    public static void main(String[] args) throws Exception {
        // Example of making a HTTP POST request using Java HttpURLConnection with proper body
        URL url = new URL("https://api.example.com/your-endpoint");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        String parameters = "param1=value1&param2=value2";
        
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(parameters);
        }
        
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        
        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        
        System.out.println(content.toString());
    }
}
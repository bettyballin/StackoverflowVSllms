import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchPhpScriptResult {
    public static void main(String[] args) {
        try {
            // URL of the PHP script
            String urlString = "http://www.something.com/myscript?param=xy";
            
            // Create a URL object
            URL url = new URL(urlString);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("GET");
            
            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            
            // Close the connections
            in.close();
            connection.disconnect();
            
            // The content object now contains the output of the PHP script
            System.out.println("Result from PHP: " + content.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
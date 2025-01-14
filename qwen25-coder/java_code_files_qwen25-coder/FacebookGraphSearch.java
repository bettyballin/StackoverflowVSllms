import java.lang.String;
// Example Java code snippet using Facebook Graph API to search for movies

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FacebookGraphSearch {
    public static void main(String[] args) throws IOException {
        String accessToken = "YOUR_ACCESS_TOKEN";
        String query = "Inception"; // Movie name you want to search
        URL url = new URL("https://graph.facebook.com/v12.0/search?q=" + URLEncoder.encode(query, "UTF-8") + "&type=page&access_token=" + accessToken);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content.toString()); // This will print the JSON response
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
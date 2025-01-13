import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestClient {
    public void get(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == 200) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("Failed : HTTP error code : " + responseCode);
        }
    }

    public static void main(String[] args) {
        try {
            RestClient client = new RestClient();
            client.get("http://example.com"); // Replace with the desired URL
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
        }
    }
}
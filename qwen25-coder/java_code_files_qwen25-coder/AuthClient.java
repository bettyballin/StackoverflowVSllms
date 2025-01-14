import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthClient {
    public static void main(String[] args) throws Exception {
        String AUTH_SERVER = "example.com"; // Replace with your auth server
        String uname = "username";           // Replace with the username
        String pass = "password";           // Replace with the password

        String urlString = "https://" + AUTH_SERVER + "/auth/authenticate.asp?pt1=" + uname + "&pt2=" + pass + "&pt4=full";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Print result
            System.out.println(content.toString());
        } else {
            System.out.println("GET request not worked");
        }

        connection.disconnect();
    }
}
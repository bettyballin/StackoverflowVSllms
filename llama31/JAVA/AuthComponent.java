import java.net.*;
import java.io.*;

public class AuthComponent {
    public static void main(String[] args) throws Exception {
        String uname = "username";
        String pass = "password";
        String authServer = "auth.server.com";
        String url = "https://" + authServer + "/auth/authenticate.asp?pt1=" + uname + "&pt2=" + pass + "&pt4=full";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "text/plain");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Process the response
            System.out.println(response.toString());
        } else {
            System.out.println("Failed : HTTP error code : " + responseCode);
        }
    }
}
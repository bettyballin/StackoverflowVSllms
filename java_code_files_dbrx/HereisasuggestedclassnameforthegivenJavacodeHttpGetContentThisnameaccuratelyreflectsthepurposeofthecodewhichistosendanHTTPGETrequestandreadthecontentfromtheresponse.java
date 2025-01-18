import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HereisasuggestedclassnameforthegivenJavacodeHttpGetContentThisnameaccuratelyreflectsthepurposeofthecodewhichistosendanHTTPGETrequestandreadthecontentfromtheresponse {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            String encoding = "UTF-8"; // default value in case the get doesn't give us anything!

            if (con.getContentEncoding() != null) { // check for null case
                encoding = con.getContentEncoding();
            }

            // Now let's read the data from the connection by specifying the UTF-8 or any other acquired charset
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8)); // or use encoding variable, but note it needs to be valid one as mentioned above!
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("read data : " + inputLine);
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Unable to acquire information about content type: " + ex);
        }
    }
}
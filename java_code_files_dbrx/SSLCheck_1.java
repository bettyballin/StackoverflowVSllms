import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class SSLCheck_1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com"); // replace with your server URL
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();

            if(responseCode == -1){
                System.out.println("SSL not enabled on this server");
            } else{
                System.out.println("SSL is enabled on this server");
                // You may want to also check the response code for a successful HTTPS request (e.g., 200)
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
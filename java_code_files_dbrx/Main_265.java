import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://your-webservice");    // Initialize with your web service endpoint
                
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();     // Open a connection to the specified remote object using this URL
            try { 
                con.connect(); 
            } catch(IOException e1) {
                e1.printStackTrace();
            }   // Establish connection!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
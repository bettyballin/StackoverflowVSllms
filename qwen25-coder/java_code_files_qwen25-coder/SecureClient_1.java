import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class SecureClient_1 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://yourserver/yourwebservice");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        try {
            // Optionally set custom SSLContext if needed
            // con.setSSLSocketFactory(sslContext.getSocketFactory());

            int responseCode = con.getResponseCode();
            System.out.println("Response Code :  " + responseCode);
        } finally {
            con.disconnect();
        }
    }
}
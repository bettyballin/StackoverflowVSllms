import java.lang.String;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class WebServiceClient_3_3 {
    public static void main(String[] args) throws Exception {
        // Set the URL of the web service
        URL url = new URL("https://example.com/webservice");

        // Create a trust manager factory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init((KeyStore) null);

        // Create an SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Open a connection to the web service
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());

        // Set the request method and headers
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Get the response
        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);
    }
}
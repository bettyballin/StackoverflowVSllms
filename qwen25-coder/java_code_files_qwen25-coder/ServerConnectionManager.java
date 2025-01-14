import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class ServerConnectionManager {
    public void connectToServer(String serverUrl) {
        try {
            URL url = new URL(serverUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            
            // Set up default SSL context and trust manager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(null); // Load default keystore (trust store)
            tmf.init(ks);
            
            sslContext.init(null, tmf.getTrustManagers(), null);
            connection.setSSLSocketFactory(sslContext.getSocketFactory());
    
            connection.connect();
    
            if (connection.getResponseCode() == 200) {
                System.out.println("Connection successful and trusted.");
            } else {
                System.out.println("Failed to connect or untrusted certificate detected.");
            }
        } catch (Exception e) {
            System.err.println("Error connecting: " + e.getMessage());
            // Handle the exception, possibly terminate application
        }
    }

    public static void main(String[] args) {
    }
}
import java.lang.String;
import java.lang.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.security.SecureRandom;

public class SecureHttpsClient {
    public void secureCommunication() {
        URL url;
        HttpsURLConnection connection = null;
        try {
            url = new URL("https://mail.google.com");
            connection = (HttpsURLConnection) url.openConnection();
            
            // Set up the SSL context to use TLS
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new SecureRandom());
            connection.setSSLSocketFactory(sslContext.getSocketFactory());

            int responseCode = connection.getResponseCode();
            System.out.println("HTTPS Response Code :: " + responseCode);

            // Read data securely
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.disconnect();
        }
    }
    public static void main(String[] args) {
    }
}
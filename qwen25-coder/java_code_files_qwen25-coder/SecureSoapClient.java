import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

public class SecureSoapClient {

    public static void main(String[] args) throws Exception {
        // Load the Key Store with your client certificate
        String keyStorePath = "path/to/keystore.p12"; // PKCS#12 format for example
        char[] password = "password".toCharArray();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(keyStorePath)) {
            keyStore.load(fis, password);
        }

        // Set up the Key Manager Factory to use your keystore
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password);

        // Create an SSLContext using the Key Managers from the KeyManagerFactory
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

        // Set the SSLSocketFactory to HttpClient
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

        // Now you can proceed with setting up your SOAP connection
        // Example:
        /*
        URL url = new URL(wsdlLocation);
        URLConnection urlConn = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConn;
        HttpsURLConnection httpsConn = (HttpsURLConnection) httpConn;

        // Make your web service call using httpsConn
        */
    }
}
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SSLClientExample {
    public static void main(String[] args) throws Exception {
        // Load the KeyStore containing the client certificate
        String keyStorePath = "path/to/your/clientkeystore.jks";
        String keyStorePassword = "clientKeystorePassword";

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());

        // Initialize the KeyManagerFactory with client certificates
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, keyStorePassword.toCharArray());

        // Initialize TrustManagerFactory which does the certificate validation
        String trustStorePath = "/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Home/lib/security/cacerts";
        String trustStorePassword = "changeit"; // default password

        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(new FileInputStream(trustStorePath), trustStorePassword.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ts);

        // Create the SSLContext and initialize it
        SSLContext sslc = SSLContext.getInstance("TLS"); // Use TLS, not SSLv2 or SSLv3
        sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        // Set up the connection
        SSLSocketFactory factory = sslc.getSocketFactory();
        URL url = new URL("https://somehost.dk:3049");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setSSLSocketFactory(factory);

        // Connect and read response
        int responseCode = con.getResponseCode();
        System.out.println("Response Code :  " + responseCode);

        con.disconnect();
    }
}
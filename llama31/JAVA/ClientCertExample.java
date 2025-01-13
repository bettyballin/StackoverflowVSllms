import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class ClientCertExample {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("/path/to/keystore"), "keystorepassword".toCharArray());

        // Create a KeyManagerFactory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, "clientcertpassword".toCharArray());

        // Create an SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        // Get the SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create the URL and open the connection
        URL url = new URL("https://somehost.dk:3049");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        // Set the SSLSocketFactory
        conn.setSSLSocketFactory(sslSocketFactory);

        // Get the input stream
        conn.connect();
        InputStream inputstream = conn.getInputStream();

        // Read from the input stream
        int byteRead;
        while ((byteRead = inputstream.read()) != -1) {
            System.out.print((char) byteRead);
        }
        inputstream.close();
    }
}
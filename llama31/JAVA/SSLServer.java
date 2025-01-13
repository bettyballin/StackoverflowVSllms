import java.io.FileInputStream;
import java.lang.String;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("mykeystore.jks"), "mystorepass".toCharArray());

        // Set up the key manager factory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, "mystorepass".toCharArray());

        // Create the SSL context
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), null, null);

        // Create the SSL server socket factory
        SSLServerSocketFactory ssf = sc.getServerSocketFactory();

        // Create the SSL server socket
        SSLServerSocket s = (SSLServerSocket) ssf.createServerSocket(8888);
        s.setNeedClientAuth(true); // Require client authentication

        // Handle incoming connections...
    }
}
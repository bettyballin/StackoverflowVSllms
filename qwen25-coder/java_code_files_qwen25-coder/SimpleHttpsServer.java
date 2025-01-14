import java.lang.String;
import java.security.KeyStore;
import javax.net.ssl.*;
import java.io.*;

public class SimpleHttpsServer {
    public static void main(String[] args) throws Exception {
        // Load the keystore containing your private key and certificate chain
        char[] password = "password".toCharArray();  // Keystore and key password
        KeyStore ks = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream("mykeystore.jks");
        ks.load(fis, password);

        // Setup the ssl context for HTTPS, load the keystore with your private cert/key
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, password);

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), null, null);

        // Create and configure server socket factory
        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        SSLServerSocket ssocket = (SSLServerSocket)ssf.createServerSocket(8443);  // Common HTTPS port

        System.out.println("Listening for connections...");

        SSLSocket csocket = null;
        try {
            // Accept an incoming connection
            csocket = (SSLSocket)ssocket.accept();

            // Configure connection parameters if desired...
            csocket.startHandshake();   // Start TLS handshake process

            BufferedReader in = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(csocket.getOutputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                out.write(line);  // echo back to the client
            }
        } finally {
            if (null != csocket) {
                csocket.close();
            }
        }

        ssocket.close();
    }
}
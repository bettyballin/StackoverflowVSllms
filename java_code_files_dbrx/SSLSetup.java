import javax.net.ssl.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.io.FileInputStream;
import java.io.IOException;

public class SSLSetup {
    public static void main(String[] args) {
        try {
            // Java TM Factory implementation - PKIX
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");  

            // Initialize KeyStore
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] password = "password".toCharArray();

            // Load KeyStore from file
            ks.load(new FileInputStream("path to your truststore"), password);

            // Initialize with your keystore containing trusted entries only!
            try { 
                tmf.init(ks); 
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }  

            // Transport layer security - successor of SSL
            SSLContext sslCtx = null;
            sslCtx = SSLContext.getInstance("TLS");  

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

            // Initialize KeyManagerFactory
            try { 
                kmf.init(ks, password); // Password for TS
            } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e1){
                e1.printStackTrace();
            }

            // Initialize SSLContext with your TrustManager and Key Managers!
            sslCtx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom()); 

        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException | CertificateException | IOException e1) {
            e1.printStackTrace();
        }
    }
}
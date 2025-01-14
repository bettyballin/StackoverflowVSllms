import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

public class CxfClientConfig {

    public static void configureCxfClientWithTLS(org.example.YourWebService service) throws Exception {
        // Initialize the client proxy
        Client client = ClientProxy.getClient(service);

        // Obtain the HTTP conduit to configure SSL settings
        HTTPConduit http = (HTTPConduit) client.getConduit();

        // Create TLSClientParameters and set them in the HTTP conduit
        TLSClientParameters tlsParams = new TLSClientParameters();
        http.setTlsClientParameters(tlsParams);

        // Load client certificate
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream("/path/to/your/client.p12");
        char[] password = "clientKeystorePassword".toCharArray();
        keyStore.load(fis, password);
        
        // Initialize KeyManagerFactory with the keystore
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password);

        // Set the KeyManagers into TLSClientParameters
        tlsParams.setKeyManagers(kmf.getKeyManagers());

        // Load trusted certificates (if needed)
        KeyStore trustStore = KeyStore.getInstance("JKS");
        FileInputStream tis = new FileInputStream("/path/to/trusted/cacerts");
        char[] trustPassword = "trustedKeystorePassword".toCharArray();
        trustStore.load(tis, trustPassword);

        // Initialize TrustManagerFactory with the truststore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        
        // Set the TrustManagers into TLSClientParameters
        tlsParams.setTrustManagers(tmf.getTrustManagers());

        // Enable certificate validation (mutual authentication)
        tlsParams.setDisableCNCheck(true);  // Use this with care; it disables CN checking

        // Close streams
        fis.close();
        tis.close();
    }

    public static void main(String[] args) {
    }
}
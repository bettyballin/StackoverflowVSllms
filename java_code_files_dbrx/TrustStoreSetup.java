import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class TrustStoreSetup {
    static {
        System.setProperty("javax.net.ssl.trustStore", "myTrustStore"); // path to your truststore pkcs12 file.
        System.setProperty("javax.net.ssl.trustStorePassword", "<password>"); // password for PKCS#12 certificate archive
        // optional: if format is different than keystore type default, you have to set it using 'javax.net.ssl.keyStoreType' property
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example_server/example_endpoint");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        InputStream ins = con.getInputStream();
    }
}
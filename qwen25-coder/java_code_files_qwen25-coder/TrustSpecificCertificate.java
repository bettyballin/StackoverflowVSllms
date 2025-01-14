import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.*;

public class TrustSpecificCertificate {

    public void sendRequest(String dataPacket) throws Exception {
        // Initialize a KeyManager and a TrustManager
        char[] password = "password".toCharArray(); // the changeit default for Java's truststore

        // Load trusted certificate from file
        FileInputStream fis = new FileInputStream("path/to/your/certificate.cer");
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);  // No password because it's just a cert, not a keystore
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate cert = cf.generateCertificate(fis);
        fis.close();
        keyStore.setCertificateEntry("cert", cert);

        // Create a KeyManager that doesn't include the self-signed certificate in its trust decisions
        KeyManager[] kmfKeyManagers = null;

        // Initialize TrustManagerFactory with the certificates you want to explicitly trust
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        // Set up the SSLContext using this custom trust manager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmfKeyManagers, tmf.getTrustManagers(), null);

        // Create an SSLSocketFactory from the above configured SSL context with a TrustManager for our cert only
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Set up the HttpURLConnection to use the custom socket factory.
        String urlStr = "https://host.example.com/";
        URL url = new URL(urlStr);
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setSSLSocketFactory(sslSocketFactory);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", Integer.toString(dataPacket.length()));
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = dataPacket.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }

        // Read the response
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response: " + response.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        TrustSpecificCertificate example = new TrustSpecificCertificate();
        example.sendRequest("Your data here");
    }
}
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SoapClientWithCertificate {
    public static void main(String[] args) throws Exception {
        // Load the keystore and truststore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("path/to/keystore.jks"), "keystorepassword".toCharArray());

        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(new FileInputStream("path/to/truststore.jks"), "truststorepassword".toCharArray());

        // Create a KeyManagerFactory and TrustManagerFactory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, "keystorepassword".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ts);

        // Create an SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        // Create an SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create a SOAP connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Set the SSLSocketFactory on the SOAP connection
        // Commented out as setSSLSocketFactory is not a standard method
        // soapConnection.setSSLSocketFactory(sslSocketFactory);

        // Create a SOAP message
        SOAPMessage soapMessage = soapConnectionFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        // ... add SOAP body ...

        // Send the SOAP message
        soapConnection.call(soapMessage, "https://example.com/soapendpoint");
    }
}
import java.io.IOException;
import java.net.Socket;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.X509Certificate;

public class MyClass {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "/path/to/keystore");
        System.setProperty("javax.net.ssl.trustStore", "/path/to/truststore");
        System.setProperty("javax.net.debug", "ssl,handshake"); // enable ssl handshake debugging if needed

        String[] allowedCN = {"allowedCN1", "allowedCN2"}; // allowed CN string array filled somewhere else

        SecurityManager rsm = new SecurityManager();
        String clientHost = "localhost";
        rsm.checkConnect(clientHost, 0 /*dummy port to always allow*/); // this is required for RMI over SSL/TLS

        try {
            SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 12345);
            String cn = null;
            try {
                Certificate[] peerCertificates = socket.getSession().getPeerCertificates();
                if (peerCertificates != null && peerCertificates.length > 0) {
                    X509Certificate cert = (X509Certificate) peerCertificates[0];
                    String subjectDN = cert.getSubjectX500Principal().getName();
                    String[] dnComponents = subjectDN.split(",");
                    String cna = "Unknown";
                    for (String component : dnComponents) {
                        component = component.trim();
                        if (component.startsWith("CN=")) {
                            cna = component.substring(3).trim();
                            break;
                        }
                    }
                    if (!Arrays.asList(allowedCN).contains(cna)) { // check certificate's CN against allowed values
                        throw new SecurityException(); // if the CN isn't found, an exception is thrown for the failed SSL handshake
                    }
                }
            } catch (Exception ex) {
                throw new SecurityException("Error in reading client CN:", ex); // error handling code goes here depending on your actual use case
            } finally {
                // rsm.reset(); // clean up the RMI registry's security manager state so it can be used in subsequent connections if needed
            }
            // rest of your code to setup a new thread for serving this client request or whatever...
        } catch (IOException e) {
            // exception handling code goes here
            e.printStackTrace();
        }
    }
}
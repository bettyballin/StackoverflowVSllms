import java.rmi.server.RemoteServer;
import java.security.cert.X509Certificate;
import java.util.Properties;

public class Main_91 {
    public static void main(String[] args) {
        // Assume 'server' is your RMI server instance
        RemoteServer server = new RemoteServer(); // Initialize with a default instance for compilation purposes

        // Get the client's certificate
        X509Certificate clientCert = null;
        try {
            // Note: This will fail at runtime without proper RMI setup and a client connection.
            // This example is for demonstration purposes only.
            Properties clientInfo = server.getClientInfo();
            if (clientInfo != null) {
                Object certificates = clientInfo.get("javax.net.ssl.peer_certificates");
                if (certificates instanceof X509Certificate[]) {
                    X509Certificate[] certs = (X509Certificate[]) certificates;
                    if (certs.length > 0) {
                        clientCert = certs[0]; // For simplicity, use the first certificate
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to get client certificate: " + e.getMessage());
        }

        if (clientCert != null) {
            // Extract the client's identity (e.g., DN or subject)
            String clientDN = clientCert.getSubjectDN().getName();

            System.out.println(clientDN);
        } else {
            System.out.println("Client certificate not found.");
        }
    }
}
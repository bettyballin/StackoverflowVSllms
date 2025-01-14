import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

public class CustomXMPPClient {

    private static final String SERVER_HOST = "yourserver.com";
    private static final int SERVER_PORT = 5222; // Default XMPP port
    private static final String USERNAME = "customuser"; // Username for custom client
    private static final String PASSWORD = "securepassword"; // Password for custom client

    public static void main(String[] args) {
        XMPPTCPConnectionConfiguration config =
            XMPPTCPConnectionConfiguration.builder()
                .setUsernameAndPassword(USERNAME, PASSWORD)
                .setHost(SERVER_HOST)
                .setPort(SERVER_PORT)
                .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled) // For demonstration only; use TLS in production
                .setResource("CustomClient")
                .build();

        try {
            XMPPTCPConnection connection = new XMPPTCPConnection(config);
            connection.connect();
            connection.login();
            System.out.println("Logged in as Custom Client");
            // Additional code to send/receive messages and handle interactions
        } catch (Exception e) {
            System.err.println("Failed to connect or login: " + e.getMessage());
        }
    }
}
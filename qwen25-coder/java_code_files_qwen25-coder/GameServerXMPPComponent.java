import org.jivesoftware.smack.*;
import org.jivesoftware.smack.tcp.*;

public class GameServerXMPPComponent {
    public static void main(String[] args) throws Exception {
        XMPPTCPConnectionConfiguration config = 
            XMPPTCPConnectionConfiguration.builder()
                .setXmppDomain("yourdomain.com")
                .setPort(5275)
                .setSecurityMode(XMPPTCPConnectionConfiguration.SecurityMode.disabled)
                // Use TLS in production
                .setServiceName("component.yourdomain.com")
                .build();

        XMPPTCPConnection connection = new XMPPTCPConnection(config);
        connection.connect();
        connection.login();

        // Handle client sessions and routing of messages here

        connection.disconnect();
    }
}
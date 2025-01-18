import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.XMPPException.XMPPErrorException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormNode;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.xdata.FormType;

public class MyClass {
    public static void main(String[] args) throws Exception {
        String username = "<username>"; // Replace with your username
        String password = "<password>"; // Replace with your password
        String server = "server"; // Replace with your server
        int port = 5222; // Replace with your port

        XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
                .setXmppDomain(server)
                .setHost(server)
                .setPort(port)
                .setSecurityMode(SecurityMode.ifpossible)
                .build();

        AbstractXMPPConnection conn = new XMPPTCPConnection(config);
        conn.connect();
        conn.login(username, password);

        PubSubManager manager = PubSubManager.getInstance(conn);

        String nodeId = "http://yournamespace.com/yournode"; // Replace with your namespace and node

        LeafNode node = null;
        try {
            node = manager.getLeafNode(nodeId);
        } catch (XMPPErrorException e) {
            if (e.getStanzaError().getCondition() == StanzaError.Condition.item_not_found) {
                // Node does not exist
                node = null;
            } else {
                throw e;
            }
        }

        if (node == null) {
            // Create new node
            ConfigureForm form = new ConfigureForm(FormType.submit);
            form.setAccessModel(AccessModel.open);
            form.setPersistentItems(true);
            form.setSubscribe(true);
            form.setTitle("My Node Title"); // Replace with your title

            node = manager.createNode(nodeId, form);
        }

        conn.disconnect();
    }
}
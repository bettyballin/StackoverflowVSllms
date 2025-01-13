import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.filter.PacketFilter;

public class XMPPClient {
  public static void main(String[] args) {
    ConnectionConfiguration config = new ConnectionConfiguration("example.com", 5222);
    XMPPConnection connection = new XMPPConnection(config);

    try {
      connection.connect();
      connection.login("username", "password");

      // Send a message to another user
      Message message = new Message("otheruser@example.com");
      message.setBody("Hello, world!");
      connection.sendPacket(message);

      // Receive messages
      PacketListener packetListener = new PacketListener() {
        public void processPacket(Packet packet) {
          if (packet instanceof Message) {
            Message message = (Message) packet;
            System.out.println("Received message: " + message.getBody());
          }
        }
      };
      PacketFilter packetFilter = new PacketFilter() {
        public boolean accept(Packet packet) {
          return packet instanceof Message;
        }
      };
      connection.addPacketListener(packetListener, packetFilter);
    } catch (XMPPException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
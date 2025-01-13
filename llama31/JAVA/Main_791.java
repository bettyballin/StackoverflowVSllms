import com.cisco.jtapi.JtapiPeer;
import com.cisco.jtapi.JtapiSession;

public class Main_791 {
    public static void main(String[] args) {
        try {
            // Create a JTAPI peer
            JtapiPeer peer = new JtapiPeer("localhost", 1099);

            // Create a JTAPI session
            JtapiSession session = peer.createSession("your_app_name");

            // Connect to the simulator
            session.connect("simulator://localhost:1099");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
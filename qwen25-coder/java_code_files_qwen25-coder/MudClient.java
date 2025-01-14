import org.apache.commons.net.telnet.TelnetClient;

public class MudClient {
    private TelnetClient tc;

    public void connect(String server, int port) throws Exception {
        tc = new TelnetClient();
        try {
            tc.connect(server, port);
            System.out.println("Connected to " + server + ":" + port);

            // You can now use `tc.getInputStream()` and `tc.getOutputStream()`
            // to interact with the MUD server.

        } catch (Exception e) {
            throw new Exception("Error connecting: " + e.getMessage());
        }
    }

    public void disconnect() throws Exception {
        if (tc != null) {
            tc.disconnect();
            System.out.println("Disconnected");
        }
    }

    // Additional methods for reading/writing to the server can be added here

    public static void main(String[] args) {
        // Main method remains empty
    }
}
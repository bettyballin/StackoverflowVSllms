import java.lang.String;
import java.net.Socket;
import java.net.URL;
import java.net.MalformedURLException;

public class AppletSocketMessenger {
    private void sendMsg(String msg) {
        Socket s = null;
        try {
            // Get the URL of the applet's codebase
            URL codebase = getCodeBase();
            // Get the hostname from the codebase URL
            String hostname = codebase.getHost();
            // Connect to the server on the specified port
            s = new Socket(hostname, 11000);
        } catch (Exception e) {
            System.err.println("Error establishing socket connection:");
            e.printStackTrace();
            return;
        }
        // ...
    }

    // Since Applet's getCodeBase() is not available in a standard Java application,
    // we need to implement it ourselves or use a different approach.
    // Here, we're assuming it's a static method for simplicity.
    private URL getCodeBase() throws MalformedURLException {
        return new URL("http://localhost"); // Replace with your applet's codebase URL
    }

    public static void main(String[] args) {
        AppletSocketMessenger messenger = new AppletSocketMessenger();
        messenger.sendMsg("Hello, World!");
    }
}
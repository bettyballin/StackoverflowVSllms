/*
 * Decompiled with CFR 0.152.
 */
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class AppletSocketMessenger {
    private void sendMsg(String string) {
        Socket socket = null;
        try {
            URL uRL = this.getCodeBase();
            String string2 = uRL.getHost();
            socket = new Socket(string2, 11000);
        }
        catch (Exception exception) {
            System.err.println("Error establishing socket connection:");
            exception.printStackTrace();
            return;
        }
    }

    private URL getCodeBase() throws MalformedURLException {
        return new URL("http://localhost");
    }

    public static void main(String[] stringArray) {
        AppletSocketMessenger appletSocketMessenger = new AppletSocketMessenger();
        appletSocketMessenger.sendMsg("Hello, World!");
    }
}

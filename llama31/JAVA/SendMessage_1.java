import java.lang.String;
import java.lang.Set;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;
import javax.microedition.io.Connector;

public class SendMessage_1_1 extends MIDlet {

    public void startApp() {
        try {
            // Create a message connection
            MessageConnection conn = (MessageConnection) Connector.open("sms://:1234");

            // Create a text message
            TextMessage msg = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);

            // Set the message text
            msg.setPayloadText("Hello, World!");

            // Send the message
            conn.send(msg);
        } catch (Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) throws MIDletStateChangeException {
    }

	public static void main(String[] args) {
		new SendMessage_1().startApp();
	}
}
import java.lang.String;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MultipartMessage;
import javax.wireless.messaging.MessagePart;
import javax.microedition.io.Connector;

public class MmsSender {
    public static void main(String[] args) {
        String phoneNumber = "+1234567890"; // replace with the actual phone number
        try {
            MessageConnection conn = (MessageConnection) Connector.open("mms://:" + phoneNumber);
            MultipartMessage msg = new MultipartMessage("Hello World!", "text/plain", "UTF-8");
            msg.addMessagePart(new MessagePart("text/plain", "Hello World!".getBytes(), "UTF-8", "X-Mms-Application-ID: generic"));
            conn.send(msg);
            conn.close();
        } catch (Exception e) {
            System.out.println("Error sending MMS: " + e.getMessage());
        }
    }
}
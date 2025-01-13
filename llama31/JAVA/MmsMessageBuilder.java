import java.lang.String;

public class MmsMessageBuilder {
    public static void main(String[] args) {
        MessagePart part = new MessagePart("text/plain", "Hello World!".getBytes(), "UTF-8", "X-Mms-Application-ID: generic");
    }
}
class MessagePart {
    public MessagePart(String type, byte[] content, String encoding, String appId) {
        // implementation of MessagePart constructor
    }
}
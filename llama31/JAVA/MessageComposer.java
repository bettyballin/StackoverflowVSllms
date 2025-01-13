import java.lang.String;

public class MessageComposer {
    String message = "Hello" + ProtocolConstants.RECORD_SEPARATOR + "World" + ProtocolConstants.END_OF_TEXT;

    public static void main(String[] args) {
        MessageComposer composer = new MessageComposer();
        System.out.println(composer.message);
    }
}

class ProtocolConstants {
    public static final String RECORD_SEPARATOR = "\u001E"; // RS
    public static final String END_OF_TEXT = "\u0003"; // ETX
}
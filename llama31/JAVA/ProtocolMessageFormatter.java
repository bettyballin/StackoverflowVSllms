import java.lang.String;

public class ProtocolMessageFormatter {
    // Define ProtocolConstants class with RECORD_SEPARATOR and END_OF_TEXT fields
    public static class ProtocolConstants {
        public static final char RECORD_SEPARATOR = '\u001E'; // ASCII Record Separator (RS)
        public static final char END_OF_TEXT = '\u0003'; // ASCII End of Text (ETX)
    }

    String message = String.format("Hello%cWorld%c", ProtocolConstants.RECORD_SEPARATOR, ProtocolConstants.END_OF_TEXT);

    public static void main(String[] args) {
        // Create an instance of ProtocolMessageFormatter to avoid compiler warning
        ProtocolMessageFormatter formatter = new ProtocolMessageFormatter();
    }
}
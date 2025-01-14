import java.lang.String;
public class ProtocolConstants {
    // Define the non-printable characters as constants
    public static final char RECORD_SEPARATOR = '\u001E'; // ASCII x1E
    public static final char END_OF_TEXT = '\u0003';      // ASCII x03

    public static void main(String[] args) {
        // Example usage with StringBuilder
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("This is a record");
        messageBuilder.append(RECORD_SEPARATOR);
        messageBuilder.append("End of the message");
        messageBuilder.append(END_OF_TEXT);

        String finalMessage = messageBuilder.toString();

        System.out.println(finalMessage); // This will not print the non-printable characters visibly

        // Sending over TCP (example pseudocode)
        // tcpOutputStream.write(finalMessage.getBytes(StandardCharsets.UTF_8));
    }
}
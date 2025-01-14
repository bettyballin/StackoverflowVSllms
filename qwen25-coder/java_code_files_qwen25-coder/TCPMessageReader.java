import java.lang.String;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TCPMessageReader {
    private DataInputStream inputStream;

    public TCPMessageReader(InputStream in) {
        this.inputStream = new DataInputStream(in);
    }

    public String readMessage() throws IOException {
        // Read the length of the message (assuming it's an int)
        int messageLength = inputStream.readInt();

        // Create a byte array to hold the message
        byte[] messageBytes = new byte[messageLength];

        // Read the entire message into the byte array
        int totalRead = 0;
        while (totalRead < messageLength) {
            int read = inputStream.read(messageBytes, totalRead, messageLength - totalRead);
            if (read == -1) {
                throw new IOException("Unexpected end of stream");
            }
            totalRead += read;
        }

        // Convert the byte array to a String
        return new String(messageBytes, "UTF-8"); // Ensure you use the correct charset if different
    }

	public static void main(String[] args) {
	}
}
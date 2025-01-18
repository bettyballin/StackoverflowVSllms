import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;

public class StreamRewrite {
    public void rewrite(ReadableByteChannel inbound, WritableByteChannel outbound) throws Exception {
        // Create a buffer with 1024 bytes
        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (true) {
            int bytesRead = inbound.read(buf);
            if (bytesRead < 0) break;

            buf.flip(); // Make the buffer ready for write mode

            byte[] dataBytes = new byte[buf.remaining()];
            buf.get(dataBytes);
            String contentData = new String(dataBytes, StandardCharsets.US_ASCII);

            /*
             * Here you can manipulate the binary stream such as replacing XML or any other operation as per your requirement
             */
            if (contentData.contains("<xml>")) { // Let's say we are looking to replace "<xml>" with "<other-tag>".
                contentData = contentData.replaceFirst("<xml>", "<other-tag>");

                outbound.write(ByteBuffer.wrap((contentData).getBytes()));
            } else {
                // if there's no replacement needed, just write the buffer contents to socket
                outbound.write(buf);
            }

            buf.compact(); // Compacts remaining bytes in the tail of this ByteBuffer and returns it into writing mode
        }
    }

    public static void main(String[] args) {
    }
}
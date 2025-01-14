import java.lang.String;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class BinaryFileReader {

    public static void main(String[] args) {
        String filePath = "path/to/your/binaryfile.bin";
        
        try (FileInputStream fis = new FileInputStream(filePath);
             FileChannel channel = fis.getChannel()) {
             
            // Read the header
            ByteBuffer buffer = ByteBuffer.allocate(21); // 4 + 1 + 4 + 16 = 25 bytes for the header
            int bytesRead = channel.read(buffer);
            if (bytesRead != -1) {
                buffer.flip(); // Prepare buffer to be read
                Header header = new Header();
                
                // Assuming big-endian byte order, adjust if different
                header.version = buffer.getInt();
                header.type = buffer.get();
                header.beginOfData = buffer.getInt();
                header.id = StandardCharsets.UTF_8.decode(buffer.slice(0, 16)).toString().trim();
                
                System.out.println(header);
            } else {
                throw new IOException("Failed to read the header");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Header {
        int version;
        byte type;
        int beginOfData;
        String id;

        @Override
        public String toString() {
            return "Header{" +
                    "version=" + version +
                    ", type=" + type +
                    ", beginOfData=" + beginOfData +
                    ", id='" + id + '\'' +
                    '}';
        }
    }
}
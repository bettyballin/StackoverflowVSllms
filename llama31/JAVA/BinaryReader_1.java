import java.lang.String;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BinaryReader_1 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("example.bin");
             FileChannel channel = in.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);

            buffer.flip();
            int version = buffer.getInt();
            byte type = buffer.get();
            int beginOfData = buffer.getInt();
            byte[] id = new byte[16];
            buffer.get(id);

            // Read records
            while (buffer.hasRemaining()) {
                int recordLength = buffer.getInt();
                byte[] recordData = new byte[recordLength];
                buffer.get(recordData);
                // Process record data
            }
        }
    }
}
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.io.IOException;

public class LargeByteBufferWriter {
    ByteBuffer buffer = ByteBuffer.allocate(1 << 26); // allocate a large buffer of ~64MB
    WritableByteChannel channel = null;

    {
        try {
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
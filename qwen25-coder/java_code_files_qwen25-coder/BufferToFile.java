import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;

public class BufferToFile {
    public static void saveFloatBufferToFile(FloatBuffer buffer, String filePath) throws Exception {
        // Ensure the buffer is in read mode
        buffer.flip();

        try (FileOutputStream fos = new FileOutputStream(filePath);
             FileChannel channel = fos.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(buffer.remaining() * 4);
            byteBuffer.asFloatBuffer().put(buffer);
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            FloatBuffer buffer = java.nio.ByteBuffer.allocateDirect(4 * 100).asFloatBuffer();
            for (int i = 0; i < 100; i++) {
                buffer.put((float) i);
            }
            buffer.flip(); // Prepare for writing

            saveFloatBufferToFile(buffer, "output.bin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
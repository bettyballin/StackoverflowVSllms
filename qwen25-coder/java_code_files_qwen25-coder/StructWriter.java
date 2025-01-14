import java.lang.String;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class StructWriter {
    public static void main(String[] args) {
        // Data to write
        char c = 'A';  // Representing a single byte
        int i = 100;   // Representing an integer (4 bytes)

        try (FileOutputStream fos = new FileOutputStream("output.bin")) {
            // Allocate buffer with space for CHAR(1) + padding(3) + INT(4)
            ByteBuffer buffer = ByteBuffer.allocate(8);

            // Put the char in the buffer
            buffer.put((byte) c);  // Assuming ASCII, if not adjust accordingly

            // Manually add padding
            buffer.put(new byte[3]);

            // Put the int in the buffer
            buffer.putInt(i);

            // Write to file
            fos.write(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
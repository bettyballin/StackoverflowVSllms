import java.lang.String;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_439_439 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.nativeOrder()); // Use native byte order

        // Write char field (1 byte)
        buffer.put((byte) 'a');

        // Add padding (3 bytes)
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        buffer.put((byte) 0);

        // Write int field (4 bytes)
        buffer.putInt(0x12345678);

        // Write buffer to file
        try (FileOutputStream fos = new FileOutputStream("output.bin")) {
            fos.write(buffer.array());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
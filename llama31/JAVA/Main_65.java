import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Main_65 {
    public static void main(String[] args) {
        // Create a ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(3);
        buffer.order(ByteOrder.nativeOrder()); // optional

        // Put data into the buffer
        buffer.put((byte) 0xFF);
        buffer.put((byte) 0xFE);
        buffer.put((byte) 0xFD);

        // Get the data as an array
        byte[] unsignedCharArray = buffer.array();

        // Print the array (optional)
        for (byte b : unsignedCharArray) {
            System.out.println(b);
        }
    }
}
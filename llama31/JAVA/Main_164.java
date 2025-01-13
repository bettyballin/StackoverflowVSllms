import java.nio.ByteBuffer;

public class Main_164 {
    public static void main(String[] args) {
        int pixel = 0x12345678; // your pixel value
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(pixel);
        byte[] bytes = buffer.array();
        
        // Print the byte array for verification
        for (byte b : bytes) {
            System.out.printf("%02x ", b);
        }
    }
}
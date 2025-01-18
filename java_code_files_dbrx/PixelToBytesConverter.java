import java.lang.String;
import java.nio.ByteBuffer;

public class PixelToBytesConverter {
    int pixelValue = 0xFFFFFFFF; // Your pixel values goes here.
    byte[] bytes = ByteBuffer.allocate(4).putInt(pixelValue).array();
    // This will give you four bytes in the 'bytes' array. The order of R,G,B components would depend on endianness (Java default being big-endian),
    // so be mindful about that if directly mapping to byte values from int value via this method.

    public static void main(String[] args) {
    }
}
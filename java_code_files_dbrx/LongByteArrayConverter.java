import java.nio.ByteBuffer;

public class LongByteArrayConverter {
    public static long byteArrayToNumericValue(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getLong();
    }
    public static void main(String[] args) {
    }
}
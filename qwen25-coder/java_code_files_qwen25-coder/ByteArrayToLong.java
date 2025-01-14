import java.lang.String;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteArrayToLong {
    public static long byteArrayToLong(byte[] bytes) {
        if (bytes.length != 8) {
            throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");
        }
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.BIG_ENDIAN); // You can use ByteOrder.LITTLE_ENDIAN if needed
        return buffer.getLong();
    }

    public static void main(String[] args) {
        byte[] by = new byte[8]; // example byte array
        for (int i = 0; i < by.length; i++) {
            by[i] = (byte) i; // just an example initialization
        }

        long numericValue = byteArrayToLong(by);
        System.out.println("The numeric value is: " + numericValue);
    }
}
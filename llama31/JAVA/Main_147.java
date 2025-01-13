import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class Main_147 {
    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        return buffer.array();
    }

    public static void main(String[] args) {
        // Example usage:
        UUID uuid = UUID.randomUUID();
        byte[] bytes = uuidToBytes(uuid);
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
    }
}
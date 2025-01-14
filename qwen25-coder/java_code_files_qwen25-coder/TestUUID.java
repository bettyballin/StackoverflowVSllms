import java.util.UUID;
import java.nio.ByteBuffer;

public class TestUUID {
    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static void main(String[] args) {
        // Use the function
        UUID uuid = UUID.randomUUID();
        byte[] uuidBytes = uuidToBytes(uuid);
    }
}
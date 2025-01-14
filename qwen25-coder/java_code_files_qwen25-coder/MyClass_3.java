import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class MyClass {
    public static byte[] byteArray(UUID uuid) {
        long lsb = uuid.getLeastSignificantBits();
        long msb = uuid.getMostSignificantBits();

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            try (DataOutputStream dos = new DataOutputStream(bos)) {
                dos.writeLong(msb);
                dos.writeLong(lsb); // Order matters: MSB first
            }
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert UUID to byte array", e);
        }
    }
}
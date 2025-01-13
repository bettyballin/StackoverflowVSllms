import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        byte[] uuidArr = asByteArray(uuid);
        String base64Str = Base64.getEncoder().encodeToString(uuidArr);
        String trimmed = base64Str.split("=")[0];

        byte[] backArr = Base64.getDecoder().decode(trimmed);
        byte[] fixedArr = new byte[16];
        System.arraycopy(backArr, 0, fixedArr, 0, 16);

        UUID newUUID = toUUID(fixedArr);
        System.out.println("Equal to Start UUID? " + newUUID.equals(uuid));
    }

    public static byte[] asByteArray(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static UUID toUUID(byte[] byteArray) {
        ByteBuffer bb = ByteBuffer.wrap(byteArray);
        long msb = bb.getLong();
        long lsb = bb.getLong();
        return new UUID(msb, lsb);
    }
}
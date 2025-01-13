/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class UUIDTest {
    public static void main(String[] stringArray) {
        UUID uUID = UUID.randomUUID();
        byte[] byArray = UUIDTest.asByteArray(uUID);
        String string = Base64.getEncoder().encodeToString(byArray);
        String string2 = string.split("=")[0];
        byte[] byArray2 = Base64.getDecoder().decode(string2);
        byte[] byArray3 = new byte[16];
        System.arraycopy(byArray2, 0, byArray3, 0, 16);
        UUID uUID2 = UUIDTest.toUUID(byArray3);
        System.out.println("Equal to Start UUID? " + uUID2.equals(uUID));
    }

    public static byte[] asByteArray(UUID uUID) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uUID.getMostSignificantBits());
        byteBuffer.putLong(uUID.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static UUID toUUID(byte[] byArray) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        long l = byteBuffer.getLong();
        long l2 = byteBuffer.getLong();
        return new UUID(l, l2);
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class UUIDConverter {
    public static UUID bytesToUUID(byte[] byArray) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long l = byteBuffer.getLong();
        long l2 = byteBuffer.getLong();
        return new UUID(l, l2);
    }

    public static void main(String[] stringArray) {
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class Main_147 {
    public static byte[] uuidToBytes(UUID uUID) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putLong(uUID.getMostSignificantBits());
        byteBuffer.putLong(uUID.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static void main(String[] stringArray) {
        byte[] byArray;
        UUID uUID = UUID.randomUUID();
        for (byte by : byArray = Main_147.uuidToBytes(uUID)) {
            System.out.print(by + " ");
        }
    }
}

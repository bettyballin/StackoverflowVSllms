/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class UuidConverter {
    public static byte[] toByteArray(UUID uUID) {
        long l = uUID.getMostSignificantBits();
        long l2 = uUID.getLeastSignificantBits();
        byte[] byArray = new byte[16];
        for (int i = 0; i < 8; ++i) {
            byArray[i] = (byte)(l >>> 8 * (7 - i));
            byArray[8 + i] = (byte)(l2 >>> 8 * (7 - i));
        }
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}

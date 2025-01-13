/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;

public class Main_164 {
    public static void main(String[] stringArray) {
        byte[] byArray;
        int n = 305419896;
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(n);
        for (byte by : byArray = byteBuffer.array()) {
            System.out.printf("%02x ", by);
        }
    }
}

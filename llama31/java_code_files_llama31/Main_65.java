/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Main_65 {
    public static void main(String[] stringArray) {
        byte[] byArray;
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer.put((byte)-1);
        byteBuffer.put((byte)-2);
        byteBuffer.put((byte)-3);
        for (byte by : byArray = byteBuffer.array()) {
            System.out.println(by);
        }
    }
}

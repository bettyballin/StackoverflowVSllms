/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BinaryReader_1 {
    public static void main(String[] stringArray) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("example.bin");
             FileChannel fileChannel = fileInputStream.getChannel();){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            int n = byteBuffer.getInt();
            byte by = byteBuffer.get();
            int n2 = byteBuffer.getInt();
            byte[] byArray = new byte[16];
            byteBuffer.get(byArray);
            while (byteBuffer.hasRemaining()) {
                int n3 = byteBuffer.getInt();
                byte[] byArray2 = new byte[n3];
                byteBuffer.get(byArray2);
            }
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BigFileWriter_1 {
    public static void main(String[] stringArray) throws IOException {
        Path path = Paths.get("path_to_your_file", new String[0]);
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);){
            fileChannel.write(ByteBuffer.wrap(BigFileWriter_1.generateRandomBytes(200)));
            fileChannel.position(200L);
            fileChannel.write(ByteBuffer.wrap(BigFileWriter_1.generateRandomBytes(200)));
            fileChannel.position(fileChannel.size() / 2L);
            fileChannel.write(ByteBuffer.wrap(BigFileWriter_1.generateRandomBytes(200)));
        }
    }

    private static byte[] generateRandomBytes(int n) {
        byte[] byArray = new byte[n];
        return byArray;
    }
}

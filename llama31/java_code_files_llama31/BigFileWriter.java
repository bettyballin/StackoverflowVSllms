/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class BigFileWriter {
    public static void main(String[] stringArray) throws IOException {
        String string = "path_to_your_file";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(string, "rw");){
            randomAccessFile.write(BigFileWriter.generateRandomBytes(200));
            randomAccessFile.seek(200L);
            randomAccessFile.write(BigFileWriter.generateRandomBytes(200));
            randomAccessFile.seek(randomAccessFile.length() / 2L);
            randomAccessFile.write(BigFileWriter.generateRandomBytes(200));
        }
    }

    private static byte[] generateRandomBytes(int n) {
        byte[] byArray = new byte[n];
        return byArray;
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReaderChunkProcessor {
    public static void main(String[] stringArray) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("path/to/your/file", "r");){
            long l = randomAccessFile.length();
            int n = 0x100000;
            long l2 = 5 * n;
            long l3 = l2 + (long)n;
            randomAccessFile.seek(l2);
            byte[] byArray = new byte[(int)(l3 - l2)];
            randomAccessFile.readFully(byArray);
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}

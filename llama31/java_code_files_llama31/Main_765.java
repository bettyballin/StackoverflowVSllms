/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main_765 {
    public static void main(String[] stringArray) {
        String string = "path_to_your_file";
        int n = 1024;
        byte[] byArray = "Hello, World!".getBytes();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(string, "rw");){
            randomAccessFile.seek(n);
            randomAccessFile.write(byArray);
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}

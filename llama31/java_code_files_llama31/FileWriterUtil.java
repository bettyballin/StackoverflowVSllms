/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterUtil {
    public static void main(String[] stringArray) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("example.txt");){
            fileOutputStream.write("Hello, World!".getBytes());
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}

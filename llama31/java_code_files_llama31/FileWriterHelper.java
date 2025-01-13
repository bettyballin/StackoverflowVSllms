/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterHelper {
    public static void main(String[] stringArray) {
        String string = "example.txt";
        byte[] byArray = "Hello, World!".getBytes();
        boolean bl = true;
        try (FileOutputStream fileOutputStream = new FileOutputStream(string);){
            while (bl) {
                fileOutputStream.write(byArray);
                bl = false;
            }
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}

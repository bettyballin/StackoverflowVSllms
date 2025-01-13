/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static void main(String[] stringArray) {
        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            fileInputStream.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found: " + fileNotFoundException.getMessage());
        }
        catch (IOException iOException) {
            System.out.println("Error reading file: " + iOException.getMessage());
        }
    }
}

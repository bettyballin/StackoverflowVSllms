/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SecureFileHandling {
    public static void main(String[] stringArray) {
        File file = new File("/path/to/file.txt");
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = new byte[(int)file.length()];
            fileInputStream.read(byArray);
            System.out.println(new String(byArray));
        }
        catch (IOException iOException) {
            System.out.println("Error reading file: " + iOException.getMessage());
        }
    }
}

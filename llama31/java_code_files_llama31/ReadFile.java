/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] stringArray) {
        File file = new File("/path/to/file");
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = new byte[(int)file.length()];
            fileInputStream.read(byArray);
            System.out.println(new String(byArray));
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}

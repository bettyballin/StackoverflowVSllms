/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTypeChecker_1 {
    public static void main(String[] stringArray) {
        File file = new File("path/to/your/file");
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = new byte[4];
            fileInputStream.read(byArray);
            if (byArray[0] == 80 && byArray[1] == 75 && byArray[2] == 3 && byArray[3] == 4) {
                System.out.println("File is a ZIP file");
            } else {
                System.out.println("File is not a ZIP file");
            }
        }
        catch (IOException iOException) {
            System.out.println("Error: " + iOException.getMessage());
        }
    }
}

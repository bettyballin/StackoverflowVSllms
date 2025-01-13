/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTypeChecker_2 {
    public static void main(String[] stringArray) {
        Path path = Paths.get("path/to/your/file", new String[0]);
        try {
            String string = Files.probeContentType(path);
            if (string != null) {
                if (string.startsWith("text/")) {
                    System.out.println("File is a text file");
                } else {
                    System.out.println("File is a binary file");
                }
            } else {
                System.out.println("File type could not be determined");
            }
        }
        catch (IOException iOException) {
            System.out.println("Error: " + iOException.getMessage());
        }
    }
}

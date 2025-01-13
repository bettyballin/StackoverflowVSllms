/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    public static void main(String[] stringArray) {
        Path path = Paths.get("/path/to/source/file.txt", new String[0]);
        Path path2 = Paths.get("/path/to/target/", new String[0]);
        try {
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
        }
        catch (IOException iOException) {
            System.err.println("Error copying file: " + iOException.getMessage());
        }
        try {
            Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully");
        }
        catch (IOException iOException) {
            System.err.println("Error moving file: " + iOException.getMessage());
        }
    }
}

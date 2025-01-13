/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDeleter_1 {
    public static void deleteFiles(String string, String string2) {
        Path path2 = Paths.get(string, new String[0]);
        try {
            Files.list(path2).filter(path -> path.getFileName().toString().endsWith(string2)).forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                    System.out.println("Deleted file: " + String.valueOf(path.getFileName()));
                }
                catch (IOException iOException) {
                    System.out.println("Error deleting file: " + String.valueOf(path.getFileName()));
                }
            });
        }
        catch (IOException iOException) {
            System.out.println("Error listing files in directory");
        }
    }

    public static void main(String[] stringArray) {
        FileDeleter_1.deleteFiles("/path/to/directory", ".gif");
    }
}

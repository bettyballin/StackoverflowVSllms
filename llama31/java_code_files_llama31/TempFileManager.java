/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempFileManager {
    public static void main(String[] stringArray) {
        Path path = Paths.get("path_to_your_temp_file", new String[0]);
        try {
            Files.delete(path);
        }
        catch (IOException iOException) {
            System.err.println("Error deleting file: " + iOException.getMessage());
        }
    }
}

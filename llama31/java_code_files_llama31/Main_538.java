/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main_538 {
    public static void main(String[] stringArray) {
        Path path = Paths.get("path/to/new/jar", new String[0]);
        Path path2 = Paths.get("path/to/existing/jar", new String[0]);
        try {
            Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException iOException) {
            System.err.println("Error moving file: " + iOException.getMessage());
        }
    }
}

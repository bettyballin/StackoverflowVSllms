/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SecureDelete {
    public static void secureDelete(String string) throws IOException {
        Path path = Paths.get(string, new String[0]);
        Files.deleteIfExists(path);
        File file = path.toFile();
        if (file.exists()) {
            file.delete();
        }
    }

    public static void main(String[] stringArray) throws IOException {
        SecureDelete.secureDelete("path/to/your/file.txt");
    }
}

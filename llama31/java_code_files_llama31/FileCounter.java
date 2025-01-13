/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCounter {
    public static int countFiles(String string) throws IOException {
        Path path = Paths.get(string, new String[0]);
        return (int)Files.list(path).count();
    }

    public static void main(String[] stringArray) {
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileContentReader {
    public String readFileContent(String string) throws IOException {
        return new String(Files.readAllBytes(Paths.get(string, new String[0])));
    }

    public static void main(String[] stringArray) {
    }
}

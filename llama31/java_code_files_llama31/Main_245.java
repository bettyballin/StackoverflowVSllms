/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class Main_245 {
    public static void main(String[] stringArray) throws IOException {
        String string = "example";
        Path path = Paths.get(System.getProperty("user.home"), string);
        Path path2 = Files.createTempFile(path.getParent(), path.getFileName().toString(), ".tmp", new FileAttribute[0]);
        PrintWriter printWriter = new PrintWriter(path2.toFile());
        printWriter.close();
    }
}

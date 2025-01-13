/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public class TempDirExample {
    public static void main(String[] stringArray) throws IOException {
        Path path = Files.createTempDirectory("myTempDir", new FileAttribute[0]);
        System.out.println(path);
        path.toFile().deleteOnExit();
    }
}

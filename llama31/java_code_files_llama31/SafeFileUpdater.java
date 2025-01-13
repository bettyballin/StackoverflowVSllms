/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

public class SafeFileUpdater {
    public void updateFile(String string, byte[] byArray) throws IOException {
        Path path = Paths.get(string, new String[0]);
        Path path2 = Files.createTempFile(path.getParent(), "temp", ".tmp", new FileAttribute[0]);
        try {
            Files.write(path2, byArray, new OpenOption[0]);
            Files.move(path2, path, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException iOException) {
            Files.deleteIfExists(path2);
            throw iOException;
        }
    }

    public static void main(String[] stringArray) {
    }
}

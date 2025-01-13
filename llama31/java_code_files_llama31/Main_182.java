/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class Main_182 {
    public static void main(String[] stringArray) {
        Path path = Paths.get("path/to/your/file", new String[0]);
        long l = 1643723900000L;
        FileTime fileTime = FileTime.fromMillis(l);
        try {
            Files.setLastModifiedTime(path, fileTime);
        }
        catch (IOException iOException) {
            System.err.println("Error setting last modified time: " + iOException.getMessage());
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class LastAccessTime {
    public static void main(String[] stringArray) {
        String string = "/path/to/your/file.txt";
        Path path = Paths.get(string, new String[0]);
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class, new LinkOption[0]);
            long l = basicFileAttributes.lastAccessTime().toMillis();
            System.out.println("Last access time: " + l);
        }
        catch (IOException iOException) {
            System.err.println("Error reading file attributes: " + iOException.getMessage());
        }
    }
}

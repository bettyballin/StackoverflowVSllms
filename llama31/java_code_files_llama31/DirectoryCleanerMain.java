/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryCleanerMain {
    public static void main(String[] stringArray) {
        Path path = Paths.get("C:\\path\\to\\directory", new String[0]);
        long l = 1800000L;
        DirectoryCleaner directoryCleaner = new DirectoryCleaner(path, l);
    }
}

/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderScanner {
    public static void main(String[] stringArray) {
        Path path = Paths.get("/path/to/your/folder", new String[0]);
        try {
            Files.walkFileTree(path, (FileVisitor<? super Path>)new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    System.out.println(path.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException iOException) {
            System.err.println(iOException.getMessage());
        }
    }
}

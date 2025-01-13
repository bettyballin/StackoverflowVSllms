import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileIndexer {
    public static void main(String[] args) throws IOException {
        Path rootDir = Paths.get("M:\\tests\\");
        FileTime lastScanTime = FileTime.fromMillis(System.currentTimeMillis() - 86400000); // 24 hours ago

        Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (attrs.lastModifiedTime().compareTo(lastScanTime) > 0) {
                    System.out.println("Added file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                if (attrs.lastModifiedTime().compareTo(lastScanTime) > 0) {
                    System.out.println("Modified directory: " + dir);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.out.println("Removed file: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
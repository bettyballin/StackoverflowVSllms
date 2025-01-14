import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFolderScanner {

    public static void main(String[] args) {
        Path startDir = Paths.get("your/folder/path");
        List<Path> allFiles = new ArrayList<>();

        try {
            Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    allFiles.add(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Could not access file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all files
        for (Path path : allFiles) {
            System.out.println(path);
        }
    }
}
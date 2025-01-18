import java.io.*;
import java.nio.file.*;

public class FileUpdater {

    public void updateFile(String sourcePath, String targetPath) throws IOException {
        Path target = FileSystems.getDefault().getPath(targetPath);
        // Step 1: Write to a temporary file
        try (InputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(target.toAbsolutePath() + ".tmp"))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle exception and leave the original file untouched
            throw new IOException("Error writing to temporary file.", e);
        }

        // Step 2: Move the temporary file into place atomically
        Files.move(target.resolveSibling(target.getFileName() + ".tmp"), target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
    }
}
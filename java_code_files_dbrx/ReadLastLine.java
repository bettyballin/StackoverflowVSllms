import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;

public class ReadLastLine {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path_to_your_large_file");
        long fileLength = Files.size(path);

        try (RandomAccessFile raf = new RandomAccessFile(path.toString(), "r")) {
            long pos = Math.max(0, fileLength - 1024 * 1024); // Read last MB of the file
            raf.seek(pos);

            String line;
            while ((line = raf.readLine()) != null) {
                if (StringUtils.isNotEmpty(line)) {    // Remove this check if files can have empty lines in between
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e);
        }
    }
}
import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileSaver_1 {
    // Save file to a directory on disk
    public static void main(String[] args) throws Exception {
        String FILE_STORAGE_PATH = "some/directory/path";
        String fileName = "filename.txt";
        InputStream fileInputStream = new FileInputStream("sourceFile.txt");
        Path targetPath = Paths.get(FILE_STORAGE_PATH, fileName);
        Files.copy(fileInputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        fileInputStream.close();
    }
}
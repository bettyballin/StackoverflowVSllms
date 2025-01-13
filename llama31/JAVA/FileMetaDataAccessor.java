import java.io.File;

public class FileMetaDataAccessor {
    public static void main(String[] args) {
        File file = new File("path/to/file");
        long lastModified = file.lastModified();
    }
}
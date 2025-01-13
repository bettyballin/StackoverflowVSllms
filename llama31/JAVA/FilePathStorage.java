import java.util.ArrayList;
import java.util.List;

public class FilePathStorage {
    private List<String> filePaths;

    public FilePathStorage() {
        this.filePaths = new ArrayList<>();
    }

    public void addFilePath(String filePath) {
        filePaths.add(filePath);
    }

    public void removeFilePath(String filePath) {
        filePaths.remove(filePath);
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public static void main(String[] args) {
        // Example usage:
        FilePathStorage storage = new FilePathStorage();
        storage.addFilePath("/path/to/file1.txt");
        storage.addFilePath("/path/to/file2.txt");
        System.out.println(storage.getFilePaths());
        storage.removeFilePath("/path/to/file1.txt");
        System.out.println(storage.getFilePaths());
    }
}
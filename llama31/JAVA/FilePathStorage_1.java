import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePathStorage_1 {
    private List<Path> filePaths;

    public FilePathStorage() {
        this.filePaths = new ArrayList<>();
    }

    public void addFilePath(String filePath) {
        filePaths.add(Paths.get(filePath));
    }

    public void removeFilePath(String filePath) {
        filePaths.remove(Paths.get(filePath));
    }

    public List<Path> getFilePaths() {
        return filePaths;
    }

    public static void main(String[] args) {
        FilePathStorage filePathStorage = new FilePathStorage();
        filePathStorage.addFilePath("/path/to/file1.txt");
        filePathStorage.addFilePath("/path/to/file2.txt");
        System.out.println(filePathStorage.getFilePaths());
        filePathStorage.removeFilePath("/path/to/file1.txt");
        System.out.println(filePathStorage.getFilePaths());
    }
}
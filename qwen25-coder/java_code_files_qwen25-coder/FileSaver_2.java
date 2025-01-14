import java.lang.String;
import java.io.File;
import java.nio.file.Files;

public class FileSaver_2 {
    private final FileService fileService;

    public FileSaver_2(FileService fileService) {
        this.fileService = fileService;
    }

    public void save(String filePath) throws Exception {
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        String fileName = file.getName();
        fileService.saveFile(fileName, bytes);
    }

    public static void main(String[] args) {
    }
}

interface FileService {
    void saveFile(String fileName, byte[] content);
}
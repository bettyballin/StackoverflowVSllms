import java.io.File;
import org.apache.commons.io.FileUtils;

public class SecureDelete_1_1 {
    public static void secureDelete(String filePath) {
        FileUtils.deleteQuietly(new File(filePath));
    }

    public static void main(String[] args) {
        secureDelete("path/to/your/file.txt");
    }
}
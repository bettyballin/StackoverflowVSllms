import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TempDLLLoader {

    static {
        try {
            InputStream dll = TempDLLLoader.class.getResourceAsStream("/yourfolder/yourdllname.dll");
            File tempDll = File.createTempFile("temp-", ".dll");
            Files.copy(dll, tempDll.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.load(tempDll.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Your code here
    }
}
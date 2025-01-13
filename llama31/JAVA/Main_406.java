import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main_406 {
    public static void main(String[] args) throws Exception {
        Path tmpFile = Files.createTempFile("myTemplate", ".dot");
        InputStream in = Main.class.getResourceAsStream("myTemplate.dot");
        Files.copy(in, tmpFile, StandardCopyOption.REPLACE_EXISTING);
        String absolutePath = tmpFile.toAbsolutePath().toString();
        // Pass the absolutePath to MS Word to be opened as a document
        System.out.println(absolutePath);
    }
}
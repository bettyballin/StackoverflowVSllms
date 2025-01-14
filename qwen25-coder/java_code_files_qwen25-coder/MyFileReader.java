import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileReader {

    public String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
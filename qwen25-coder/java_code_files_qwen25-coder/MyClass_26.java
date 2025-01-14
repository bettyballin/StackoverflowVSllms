import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MyClass {
    public String readFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            sb.append(lines.get(i));
            if (i < lines.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
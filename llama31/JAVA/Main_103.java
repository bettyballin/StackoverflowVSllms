import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_103 {
    public static void main(String[] args) {
        String yourPathString = "/path/to/your/file"; // replace with your actual path
        Path path = Paths.get(yourPathString);
        int nameCount = path.getNameCount();
        String[] subDirs = new String[nameCount];

        for (int i = 0; i < nameCount; i++) {
            subDirs[i] = path.getName(i).toString();
            System.out.println(subDirs[i]);
        }
    }
}
import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_245 {
    public static void main(String[] args) throws Exception {
        String pathStr = "/my/directory/path"; // Change this to your own input directory path
        Path pathObj = Paths.get(pathStr);

        int countDirs = 0;
        for (Path dir : pathObj) {
            if (!dir.toString().isEmpty()) {     // skip empty strings, like the first one from a leading /
                System.out.println("Directory number " + ++countDirs + ": " + dir);
            }
        }
    }
}
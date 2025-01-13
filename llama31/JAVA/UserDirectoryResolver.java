import java.nio.file.Paths;
import java.nio.file.Path;

public class UserDirectoryResolver {
    Path userHome = Paths.get(System.getProperty("user.home"));
    Path libraryDir = userHome.resolve("Library");

    public static void main(String[] args) {
    }
}
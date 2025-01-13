import java.io.File;
import java.lang.String;

public class UserLibraryResolver {
    String userHome = System.getProperty("user.home");
    File libraryDir = new File(userHome, "Library");

    public static void main(String[] args) {
    }
}
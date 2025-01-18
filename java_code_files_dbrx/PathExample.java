import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    Path p = Paths.get("C:", "path", "to", "file"); // on Windows, this would produce C:\path\to\file
    Path f = Paths.get("/home/user/some", (String[])null, "file"); // on Linux, this would result in /home/user/some/file
    public static void main(String[] args) {
    }
}
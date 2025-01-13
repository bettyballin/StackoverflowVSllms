import java.lang.String;
import java.nio.file.Paths;

public class Main_308 {
    public static void main(String[] args) {
        System.out.println(Paths.get("a", "b"));  // prints "a/b" on Unix-like systems and "a\b" on Windows
        System.out.println(Paths.get("a", "/b")); // prints "/b" on Unix-like systems and "\b" on Windows
    }
}
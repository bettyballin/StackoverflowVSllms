import java.lang.String;
import java.io.File;

public class Main_309 {
    public static void main(String[] args) {
        System.out.println(new File("a", "b").getPath());  // prints "a/b" on Unix-like systems and "a\b" on Windows
        System.out.println(new File("a", "/b").getPath()); // prints "/b" on Unix-like systems and "\b" on Windows
    }
}
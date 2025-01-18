import java.nio.file.*;

public class ResolvePathsExample {
    public static void main(String[] args) {
        Path path1 = Paths.get("a");
        Path path2 = Paths.get("/b");
        System.out.println(path1.resolve(path2)); // outputs: /b

        Path path3 = Paths.get("a", "b");
        Path absolutePath3 = path3.toAbsolutePath();
        System.out.println(absolutePath3); // outputs the full file path to a/b e.g.: C:\Users\yourName\a\b in Windows, /home/"user"/a/b in Linux and etc.
    }
}
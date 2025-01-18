import java.lang.String;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main_77 {
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("example.txt"); // replace with your path
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        long lastAccessedTimeInMillis = attr.lastAccessTime().toMillis();
        System.out.println(lastAccessedTimeInMillis);
    }
}
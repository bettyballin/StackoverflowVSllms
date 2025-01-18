import java.lang.String;
import java.nio.file.*;
public class Main_19 {
    public static void main(String[] args) throws Exception {
        Path base = Paths.get("/var/data").normalize(); // First absolute path as the base
        Path target = Paths.get("/var/data/stuff/xyz.dat").normalize(); // Second absolute path
        Path relativePath = base.relativize(target); // Construct the relative path

        System.out.println("Relative path: " + relativePath); // Prints: ./stuff/xyz.dat
    }
}
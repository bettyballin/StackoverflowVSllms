import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePathExample_1 {
    public static void main(String[] args) {
        String absolutePath1 = "/var/data/stuff/xyz.dat";
        String absolutePath2 = "/var/data";

        Path path1 = Paths.get(absolutePath1);
        Path path2 = Paths.get(absolutePath2);

        // Compute the relative path
        Path relativePath = path2.relativize(path1);

        System.out.println(relativePath.toString());
    }
}
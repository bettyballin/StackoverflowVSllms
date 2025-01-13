import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathValidator {
    public boolean isValidPath(String path) {
        try {
            Path filePath = Paths.get(path);
            return Files.exists(filePath.getParent()) || Files.exists(filePath);
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        FilePathValidator validator = new FilePathValidator();
        System.out.println(validator.isValidPath("C:/foo")); // true
        System.out.println(validator.isValidPath("/foo")); // true
        System.out.println(validator.isValidPath("banana")); // false
    }
}
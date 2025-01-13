import java.io.File;

public class FileValidator {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Define the fileName variable
        File file = new File("path/to/permanent/location", fileName);
        if (!file.getParentFile().equals(new File("path/to/permanent/location"))) {
            // Handle directory traversal attack
            System.out.println("Directory traversal attack detected!");
        }
    }
}
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ModernJavaExamples {
    public static void main(String[] args) {

        // Java 8 Lambda Example
        List<String> colors = Arrays.asList("red", "green", "blue");
        colors.forEach(color -> System.out.println(color));

        // Java 9 Try-With-Resources (multiple resources)
        try (FileInputStream fis = new FileInputStream("file1.txt");
             FileOutputStream fos = new FileOutputStream("file2.txt")) {
            // use fis and fos here
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Java 10 Local Variable Type Inference
        var message = "Hello, modern Java!";
        System.out.println(message);
    }
}
import java.lang.String;
// Example in Java: Writing a string with Unicode characters to a file using UTF-8 encoding
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnicodeExample {
    public static void main(String[] args) throws Exception {
        // Unicode string example
        String text = "Hello, 世界!";

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("output.txt"), java.nio.charset.StandardCharsets.UTF_8)) {
            bw.write(text);
        }

        System.out.println("File written with UTF-8 encoding.");
    }
}
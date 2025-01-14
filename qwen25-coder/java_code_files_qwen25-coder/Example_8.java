import java.io.*;

public class Example {
    public static void main(String[] args) {
        try (FileInputStream fileStream = new FileInputStream("example.txt")) {
            // Use the fileStream here...
        } catch (IOException e) {
            // Handle possible I/O errors while reading from the file.
        }
        // No need to explicitly close the stream or handle its IOException as it's managed by try-with-resources
    }
}
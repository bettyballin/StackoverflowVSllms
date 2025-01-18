import java.lang.String;
import java.nio.file.*;
import java.io.*;

public class FileAppender {
    static String text = "Appended content.";
    static Path path = Paths.get("yourfilepath"); // Replace with your desired file path

    static {
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
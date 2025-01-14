import java.lang.String;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class LineEndingConverter_1 {
    public static void convertLineEndings(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Write with Unix line ending
                writer.write(line);
                writer.newLine();  // Uses the system's default newline, which could be set to LF for Unix systems
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String windowsFilePath = "path/to/windows/file.txt";
        String unixFilePath = "path/to/unix/file.txt";
        
        convertLineEndings(windowsFilePath, unixFilePath);
    }
}
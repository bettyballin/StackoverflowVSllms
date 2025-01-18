import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileConverter {
    public static void main(String[] args) throws IOException {
        String fromEncoding = "windows-1252"; // Windows Western encoding example
        Charset toEncoding = StandardCharsets.UTF_8;  // Converts text to UTF-8 format

        Path sourcePath = Paths.get("sourcefile");   // source file path and name
        Path destPath = Paths.get("convertedfile");  // destination file path and name

        try (BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(sourcePath), fromEncoding));
             BufferedWriter out = Files.newBufferedWriter(destPath, toEncoding)) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!isLastLine(in)) {
                    line += System.lineSeparator(); // Add system-specific LF, CRLF end of line markers depending on OS
                }
                out.append(line);
            }
        }
    }

    public static boolean isLastLine(Reader reader) throws IOException {
        int ch;
        while ((ch = reader.read()) > -1 && Character.isWhitespace(ch)) {
            // Ignore extra empty lines if they exist
        }
        return ch == -1;  // End of file has been reached
    }
}
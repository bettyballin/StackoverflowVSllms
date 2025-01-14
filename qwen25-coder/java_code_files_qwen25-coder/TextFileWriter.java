import java.lang.String;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class TextFileWriter {
    public static void main(String[] args) {
        String data = "78,45,New things,200, Number of columns,2.00,5";
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
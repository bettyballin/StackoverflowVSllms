import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class WriteUtf16File {
    public static void main(String[] args) throws IOException {
        String utf16String = "Your text here";

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("output.txt"),
                        StandardCharsets.UTF_16))) {

            writer.write(utf16String);
        }
    }
}
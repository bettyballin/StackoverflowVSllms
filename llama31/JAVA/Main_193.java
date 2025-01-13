import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import java.io.File;
import java.io.IOException;

public class Main_193 {
    public static void main(String[] args) throws TikaException, IOException {
        // Create a Tika instance
        Tika tika = new Tika();

        // Parse the PDF file to HTML
        // Make sure to replace "path/to/file.pdf" with the actual path to your PDF file
        String htmlContent = tika.parseToString(new File("path/to/file.pdf"));

        // Print the HTML content
        System.out.println(htmlContent);
    }
}
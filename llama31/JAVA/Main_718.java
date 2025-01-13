import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import java.io.File;
import java.io.IOException;

public class Main_718 {
    public static void main(String[] args) {
        Tika tika = new Tika();
        try {
            String htmlContent = tika.parseToString(new File("example.html"));
            System.out.println(htmlContent);
        } catch (IOException | TikaException e) {
            System.out.println("Error parsing file: " + e.getMessage());
        }
    }
}
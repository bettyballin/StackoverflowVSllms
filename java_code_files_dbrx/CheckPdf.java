import org.apache.tika.Tika;
import java.io.File;

public class CheckPdf {

    public void isPdf(File file) {
        Tika tika = new Tika(); // Create a Constructor for Tika
        String detectedType = tika.detect(file); // Using detect method to validate the given File format
        if (detectedType != null && detectedType.equals("application/pdf")) {
            System.out.println("It's a PDF file.");
        } else {
            System.out.println("It's not a PDF file.");
        }
    }

    public static void main(String[] args) {
        // Ensure a filename is provided as a command-line argument
        if (args.length < 1) {
            System.out.println("Usage: java CheckPdf <filename>");
            return;
        }

        File file = new File(args[0]);
        CheckPdf checker = new CheckPdf();
        checker.isPdf(file);
    }
}
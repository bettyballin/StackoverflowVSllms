import java.lang.String;
import java.io.File;
import java.lang.ProcessBuilder;

public class CalibrePDFtoHTMLConverter {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
                "ebook-convert",
                "input.pdf", // Input PDF file
                "output.html"); // Output HTML file

        // Start the process
        Process p = pb.start();

        // Wait for the conversion to finish and check its exit value
        int exitCode = p.waitFor();
        if (exitCode == 0) {
            System.out.println("Conversion successful.");
        } else {
            System.out.println("Conversion failed with exit code: " + exitCode);
        }
    }
}
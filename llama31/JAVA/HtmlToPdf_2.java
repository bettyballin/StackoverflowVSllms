import java.lang.String;
import java.io.File;
import java.io.IOException;

public class HtmlToPdf_2 {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.html";
        String outputFile = "output.pdf";

        ProcessBuilder pb = new ProcessBuilder("wkhtmltopdf", inputFile, outputFile);
        pb.start();
    }
}
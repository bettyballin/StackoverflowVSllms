import java.io.File;
import java.io.IOException;

public class HtmlToPdf {
    public static void main(String[] args) throws IOException, InterruptedException {
        String html = "<html><body><h1>Hello World!</h1></body></html>";
        File pdfFile = new File("output.pdf");

        ProcessBuilder pb = new ProcessBuilder("wkhtmltopdf", "--page-size", "A4", "--margin-top", "20", "--header-spacing", "5", "-", pdfFile.getAbsolutePath());
        pb.redirectErrorStream(true);
        Process process = pb.start();

        byte[] buffer = html.getBytes();
        process.getOutputStream().write(buffer);
        process.getOutputStream().close();

        process.waitFor();
    }
}
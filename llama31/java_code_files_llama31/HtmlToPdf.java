/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;

public class HtmlToPdf {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String string = "<html><body><h1>Hello World!</h1></body></html>";
        File file = new File("output.pdf");
        ProcessBuilder processBuilder = new ProcessBuilder("wkhtmltopdf", "--page-size", "A4", "--margin-top", "20", "--header-spacing", "5", "-", file.getAbsolutePath());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        byte[] byArray = string.getBytes();
        process.getOutputStream().write(byArray);
        process.getOutputStream().close();
        process.waitFor();
    }
}

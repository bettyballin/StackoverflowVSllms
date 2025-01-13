import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

public class FileDownloader_1_1 {
    public void downloadFile(HttpServletResponse response) throws Exception {
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename=\"yourfile.pdf\"");
        java.nio.file.Path filePath = Paths.get("path/to/your/file.pdf");
        long fileSize = Files.size(filePath);
        response.setHeader("Content-Length", String.valueOf(fileSize));
        try (OutputStream o = response.getOutputStream()) {
            // then write to the output stream
            Files.copy(filePath, o);
        }
    }

    public static void main(String[] args) {
        // This main method is not actually used in a servlet context,
        // but we can simulate a HttpServletResponse to test the downloadFile method
        HttpServletResponse response = null; // You would need to mock or provide an actual HttpServletResponse object
        // FileDownloader_1 downloader = new FileDownloader_1();
        // downloader.downloadFile(response);
    }
}
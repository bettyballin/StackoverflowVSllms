import java.lang.String;

public class FileDownloader {
    public static void main(String[] args) {
        // You would need to use a library or framework that supports HTTP responses
        // to set the content type and header. For simplicity, I'm just printing it.
        System.out.println("Content-Type: application/octet-stream");
        System.out.println("Content-Disposition: attachment; filename=xyz.tar");
    }
}
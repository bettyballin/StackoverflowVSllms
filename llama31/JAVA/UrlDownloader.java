import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlDownloader {
    public static void main(String[] args) throws Exception {
        URL u = new URL("my-url-string");
        URLConnection uc = u.openConnection();
        uc.connect();
        InputStream in = uc.getInputStream();
        FileOutputStream out = new FileOutputStream("output_file");
        BufferedOutputStream bos = new BufferedOutputStream(out);

        final int BUF_SIZE = 1 << 8;
        byte[] buffer = new byte[BUF_SIZE];
        int bytesRead = -1;
        while ((bytesRead = in.read(buffer)) > -1) {
            bos.write(buffer, 0, bytesRead);
        }
        in.close();
        bos.close();
    }
}
import java.lang.String;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader {
    public static void main(String[] args) {
        try {
            URL website = new URL("my-url-string");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("output-file-path"); // specify your file path here
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.lang.String;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloader_2 {

    URL url;
    URLConnection connection;

    {
        try {
            url = new URL("my-url-string");
            connection = url.openConnection();

            try (InputStream inputStream = connection.getInputStream()) {
                Files.copy(inputStream, Paths.get("/path/to/file"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileDownloader_2();
    }
}
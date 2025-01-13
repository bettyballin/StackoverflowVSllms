import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_629 {
    public static void main(String[] args) throws IOException {
        Tika tika = new Tika();
        Metadata metadata = new Metadata();
        tika.parse(new FileInputStream(new File("path/to/file.mp3")), metadata);
        String artist = metadata.get("xmpDM:artist");
        String title = metadata.get("xmpDM:title");
        System.out.println("Artist: " + artist);
        System.out.println("Title: " + title);
    }
}
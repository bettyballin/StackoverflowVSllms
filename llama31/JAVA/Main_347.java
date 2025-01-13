import java.lang.String;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main_347 {
    public static String xmlUriToWindowsPath(String uri) throws Exception {
        // Remove file:/// prefix
        String path = uri.substring(8);

        // Replace forward slashes with backslashes
        path = path.replace('/', '\\');

        // Decode URL-encoded characters
        path = URLDecoder.decode(path, StandardCharsets.UTF_8.toString());

        return path;
    }

    public static void main(String[] args) throws Exception {
        String uri = "file:///C:/DirA/DirB/With%20Spaces.txt";
        String windowsPath = xmlUriToWindowsPath(uri);
        System.out.println(windowsPath);
    }
}
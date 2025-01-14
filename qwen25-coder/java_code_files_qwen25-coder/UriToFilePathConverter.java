import java.lang.String;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UriToFilePathConverter {
    public static String convertUriToWindowsPath(String uri) {
        if (uri == null || !uri.startsWith("file:///")) {
            throw new IllegalArgumentException("Invalid URI or not a file URI");
        }

        // Remove the 'file:///' prefix
        String path = uri.substring(8);

        // Decode URL-encoded characters
        try {
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to decode URI", e);
        }

        // Replace slashes with backslashes for Windows paths
        path = path.replace('/', '\\');

        // Check and handle invalid characters in Windows filenames
        if (!isValidWindowsFilePath(path)) {
            throw new IllegalArgumentException("Invalid character found in file path");
        }

        return path;
    }

    private static boolean isValidWindowsFilePath(String path) {
        String[] invalidCharsWindows = {"<", ">", ":", "\"", "/", "\\\\", "|", "?", "*"};
        for (String c : invalidCharsWindows) {
            if (path.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String fileUri = "file:///C:/DirA/DirB/With%20Spaces.txt";
        try {
            System.out.println("Windows Path: " + convertUriToWindowsPath(fileUri));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
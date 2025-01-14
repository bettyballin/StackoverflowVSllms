import java.io.IOException;

public class FileOpenerUtils {
    public static void openDocument(String path) throws IOException {
        // Ensure the entire path is quoted
        path = "\"" + path.replace("/", "\\") + "\"";

        String command = "C:\\Windows\\System32\\cmd.exe /c start " + path;

        Runtime.getRuntime().exec(command);
    }

    public static void main(String[] args) {
    }
}
import java.io.IOException;

public class DocumentOpener {
    public static void openDocument(String path) throws IOException {
        // Replace single backslashes with double backslashes and add quotes around the entire path
        path = "\"" + path.replace("\\", "\\\\").replaceAll("[ ]+", "\\\\ ") + "\"";
        String command = "cmd /c start " + path;
        Runtime.getRuntime().exec(command);
    }
    public static void main(String[] args) {
    }
}
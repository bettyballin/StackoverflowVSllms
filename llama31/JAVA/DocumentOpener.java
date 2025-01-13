import java.io.IOException;
import java.lang.String;

public class DocumentOpener {
    public static void openDocument(String path) throws IOException {
        String[] command = {"cmd.exe", "/c", "start", "\"" + path + "\""};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.start();
    }
    public static void main(String[] args) {
    }
}
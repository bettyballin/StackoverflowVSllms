import java.lang.String;
import java.io.IOException;

public class OpenPdfAtPage_1 {
    public static void main(String[] args) {
        int pageNum = 24;
        String manualPath = "C:\\Program Files\\Foo\\Bar\\Docs\\RefMan.pdf";
        String cmdString = "start \"" + manualPath + "\" /A \"page=" + pageNum + "=OpenActions\"";

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", cmdString);
            pb.start();
        } catch (IOException e) {
            System.err.println("Error opening PDF file: " + e.getMessage());
        }
    }
}
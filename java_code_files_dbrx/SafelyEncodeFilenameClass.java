import java.io.*;
import java.nio.file.*;

public class SafelyEncodeFilenameClass {

    public void safelyEncodeFilename(String s) throws IOException {
        Path currentFile = Paths.get(System.getProperty("user.home"), s);
        String safeFileName = currentFile.toString();

        PrintWriter currentWriter = new PrintWriter(safeFileName);
    }
}
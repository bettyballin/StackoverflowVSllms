import java.io.File;

public class FileCleaner {
    public static void main(String[] args) {
        File tmpFile = new File("tmp_file.txt");
        tmpFile.deleteOnExit();
    }
}
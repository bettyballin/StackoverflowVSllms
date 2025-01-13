import java.io.File;
import java.util.Arrays;

public class FileSorter {
    public static void main(String[] args) {
        File directory = new File("."); // specify a directory
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
            // You may want to add code here to do something with the sorted files
        }
    }
}
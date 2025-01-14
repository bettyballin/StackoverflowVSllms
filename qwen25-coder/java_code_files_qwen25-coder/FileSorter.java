import java.lang.String;
import java.io.File;
import java.util.Arrays;

public class FileSorter {
    public static void main(String[] args) {
        File directory = new File("path/to/directory");
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files, (f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

            for (File file : files) {
                System.out.println(file.getName() + " " + file.lastModified());
            }
        }
    }
}
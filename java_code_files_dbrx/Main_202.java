import java.lang.String;
import java.io.File;
import java.util.*;

public class Main_202 {
    public static void main(String[] args) {
        File directory = new File("path_to_your_directory");
        File[] files = directory.listFiles();
        if (files != null) { // null check to avoid NullPointerException in case no files exist
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));
            for (File file : files) {
                System.out.println("Last modified: " + new Date(file.lastModified()));
                System.out.println(file.getPath() + "\n");
            }
        }
    }
}
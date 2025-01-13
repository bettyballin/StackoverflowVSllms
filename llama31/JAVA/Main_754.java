import java.io.File;
import java.util.Arrays;

public class Main_754 {
    public static void main(String[] args) {
        File directory = new File("/path/to/your/directory"); // replace with your directory path
        File[] files = directory.listFiles();
        if (files != null) {
            File[] sortedFiles = Arrays.stream(files)
                    .sorted((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()))
                    .toArray(File[]::new);

            // print the sorted files
            for (File file : sortedFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory not found or is empty.");
        }
    }
}
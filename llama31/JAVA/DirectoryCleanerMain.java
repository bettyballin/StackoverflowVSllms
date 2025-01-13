import java.nio.file.Paths;
import java.nio.file.Path;

public class DirectoryCleanerMain {
    public static void main(String[] args) {
        Path directory = Paths.get("C:\\path\\to\\directory");
        long retentionTime = 30 * 60 * 1000; // 30 minutes

        DirectoryCleaner cleaner = new DirectoryCleaner(directory, retentionTime);
    }
}

class DirectoryCleaner {
    public DirectoryCleaner(Path directory, long retentionTime) {
        // You may want to implement the actual directory cleaning logic here
        System.out.println("Directory cleaner initialized with directory: " + directory + " and retention time: " + retentionTime);
    }
}
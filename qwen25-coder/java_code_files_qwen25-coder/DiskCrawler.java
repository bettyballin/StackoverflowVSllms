import java.lang.String;
import java.io.File;

public class DiskCrawler {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        
        for (File root : roots) {
            System.out.println("Drive: " + root.getAbsolutePath());
        }
    }
}
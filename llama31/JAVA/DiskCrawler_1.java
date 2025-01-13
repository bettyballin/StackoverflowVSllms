import java.lang.String;
import java.nio.file.FileSystems;

public class DiskCrawler_1 {
    public static void main(String[] args) {
        FileSystems.getDefault().getFileStores().forEach(store -> {
            System.out.println(store.toString());
        });
    }
}
import java.lang.String;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileMonitor {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/your/file.csv");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey key;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && event.context().equals(path.getFileName())) {
                    // Read the new line from the file
                    // You can use a RandomAccessFile to read from the last known position
                    // Or use a FileChannel to read from the end of the file
                }
            }

            key.reset();
        }
    }
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

public class FileChangeListener {
    public static void main(String[] args) throws IOException {
        // Create a WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Register the directory to watch
        Path dir = Paths.get("/path/to/watch");
        dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            // Wait for events
            WatchKey key = watchService.take();

            // Process events
            for (WatchEvent<?> event : key.pollEvents()) {
                Kind<?> kind = event.kind();
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("File modified: " + event.context());
                }
            }

            // Reset the key
            key.reset();
        }
    }
}
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Main_63 {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("path/to/folder");
        WatchService watcher = FileSystems.getDefault().newWatchService();
        dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

        // Poll for events
        WatchKey key;
        while ((key = watcher.take()) != null) { // Change poll() to take()
            // Handle events
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    // File has changed
                    System.out.println("File has changed: " + event.context());
                }
            }
            key.reset();
        }
    }
}
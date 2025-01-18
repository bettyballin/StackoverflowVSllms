import java.nio.file.*;
import java.io.IOException;

public class DirectoryWatcher {
    private WatchService watcher;

    public DirectoryWatcher(Path dirName) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        dirName.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE); // Registering for create file event only in this case.
    }

    public void processEvents() {
        WatchKey key;
        try {
            while ((key = watcher.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) { // Get list of events for the single directory
                    if (event.kind().name().contains("ENTRY_CREATE")) { // Only process create event in this case
                        System.out.println(event.context() + "  created");
                    }
                }
                key.reset(); // Must reset the key or the watcher will not watch for new events.
            }
        } catch (Exception e) { }
    }

    public static void main(String[] args) {
    }
}
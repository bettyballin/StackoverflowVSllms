import java.io.IOException;
import java.nio.file.*;

public class FolderMonitor {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("c:/mydir"); // Your folder here

        new DirectoryWatcher(path, "img").processEvents();
    }
}

class DirectoryWatcher {

    private final WatchService watcher;
    private final Path dir;
    private final String fileType;

    DirectoryWatcher(Path dir, String fileType) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dir = dir;
        this.fileType = fileType;
        dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
    }

    void processEvents() {
        for (;;) {
            // wait for key to be signaled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    if (filename.toString().endsWith(fileType)) {
                        System.out.println("New file created: " + filename);
                        // Do something with the new file
                    }
                }
            }

            // Reset the key -- this step is critical to receive further watch events.
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
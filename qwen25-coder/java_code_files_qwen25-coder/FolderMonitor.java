import java.lang.String;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class FolderMonitor {

    public static void watchDir(Path dir, String prefix) throws IOException {
        try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            System.out.println("Monitoring directory for changes: " + dir.toString());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path filename = ev.context();

                    if (filename.toString().startsWith(prefix)) {
                        System.out.println(kind.name() + ": " + dir.resolve(filename));
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path pathToMonitor = Paths.get("/path/to/directory");
        String prefix = "img";
        watchDir(pathToMonitor, prefix);
    }
}
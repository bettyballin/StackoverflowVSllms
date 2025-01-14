import java.lang.String;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;

public class FileChangeWatcher {
    private final WatchService watcher;
    private final Path dir;

    public FileChangeWatcher(Path dir) throws IOException {
        this.dir = dir;
        watcher = FileSystems.getDefault().newWatchService();
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void processEvents() {
        for (;;) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();

                System.out.println("File " + dir.resolve(filename).getFileName() + ": " + kind.name());
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path/to/directory");
        FileChangeWatcher watcher = new FileChangeWatcher(path);
        watcher.processEvents();
    }
}
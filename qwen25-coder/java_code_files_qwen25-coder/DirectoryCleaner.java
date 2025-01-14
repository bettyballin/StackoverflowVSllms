import java.lang.String;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class DirectoryCleaner {

    private static final long FILE_LIFE = 30; // minutes

    public static void main(String[] args) throws IOException {
        Path dirToWatch = Paths.get("path/to/your/directory");

        WatchService watchService = FileSystems.getDefault().newWatchService();

        dirToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            WatchKey key;
            try {
                key = watchService.poll(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException x) {
                return;
            }

            if (key == null) {
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filename = ((WatchEvent<Path>)event).context();
                    Path filePath = dirToWatch.resolve(filename);

                    // Schedule a task to delete the file after FILE_LIFE
                    new Thread(() -> {
                        try {
                            TimeUnit.MINUTES.sleep(FILE_LIFE);
                            Files.deleteIfExists(filePath);
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }

            }

            if (!key.reset()) {
                break;
            }
        }
    }
}